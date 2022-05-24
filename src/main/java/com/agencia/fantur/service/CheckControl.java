package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class CheckControl implements ControlService {
    @Autowired
    RestTemplate clientRest;

    @Override
    public boolean validate(Booking entity) {

        JSONObject bookingAuthorization = new JSONObject();
        bookingAuthorization.put("cuit", entity.getClient().getCuit());
        bookingAuthorization.put("fecha_incio", new Date());
        bookingAuthorization.put("fecha_fin", new Date());
        bookingAuthorization.put("precio", entity.getAPackage().getPrice());


        JSONObject response = clientRest.postForObject("http://localhost:8080/operacion", bookingAuthorization, JSONObject.class);
        return response.get("aprobada").equals("true");

    }
}
