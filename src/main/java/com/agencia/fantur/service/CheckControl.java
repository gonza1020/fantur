package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import com.agencia.fantur.model.ControlRequest;
import com.agencia.fantur.model.ControlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
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

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    PackageService packageService;

    private int attemps = 1;

    @Override
    @Retryable(value = RuntimeException.class, maxAttempts = 5, backoff = @Backoff(3000))
    public boolean validate(Booking entity) {

        ControlRequest request = ControlRequest.builder().cuit(clientService.findById(entity.getClient().getId()).getCuit())
                .fecha_incio(new Date()).fecha_fin(new Date()).precio(BigDecimal.valueOf(packageService.findById(entity.getAPackage().getId()).getPrice()))
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<ControlRequest> httpEntity = new HttpEntity<>(request, headers);
        System.out.println("Attemp: " + attemps++ + " at " + new Date());
        if (attemps == 5) {
            attemps = 0;
        }
        ResponseEntity<ControlResponse> responseEntity = clientRest.postForEntity("http://localhost:8080/operacion", httpEntity, ControlResponse.class);


        ControlResponse response = responseEntity.getBody();
        System.out.println(response.isAprobada());
        attemps = 1;
        return response.isAprobada();
    }
}
