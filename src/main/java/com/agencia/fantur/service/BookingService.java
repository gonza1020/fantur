package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingService extends BaseServiceImpl<Booking,Long>{



    @Override
    public Booking save(Booking entity) throws Exception {
        JSONObject bookingAuthorization = new JSONObject();

        bookingAuthorization.put("cuit",entity.getClient().getCuit());
        bookingAuthorization.put("fecha_incio",new Date());
        bookingAuthorization.put("fecha_fin",new Date());
        bookingAuthorization.put("precio",entity.getAPackage().getPrice());

        return super.save(entity);
    }
}
