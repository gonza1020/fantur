package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import com.agencia.fantur.model.ControlRequest;
import com.agencia.fantur.model.ControlResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

@Service
public class CheckControl implements ControlService {
    @Autowired
    RestTemplate clientRest;

    @Override
    @Retryable(value = RuntimeException.class, maxAttempts = 5, backoff = @Backoff(3000))
    public boolean validate(Booking entity){

        ControlRequest request = ControlRequest.builder().cuit(entity.getCuit())
                .fecha_incio(new Date()).fecha_fin(new Date()).precio(BigDecimal.valueOf(entity.getPrice()))
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ControlRequest> httpEntity = new HttpEntity<>(request, headers);

        ResponseEntity<ControlResponse> responseEntity = clientRest.postForEntity("http://localhost:8080/operacion", httpEntity, ControlResponse.class);

        if (responseEntity.getStatusCodeValue() == 201) {
            ControlResponse response = responseEntity.getBody();
            return response.isAprobada();
        }
        throw new RuntimeException("Servicio de turismo control no disponible");

    }

    @Recover
    public String recover() {
        return "Try after some time";
    }
}
