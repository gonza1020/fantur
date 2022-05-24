package com.agencia.fantur.service;

import com.agencia.fantur.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class BookingService extends BaseServiceImpl<Booking, Long> {

    @Autowired
    ControlService controlService;


    @Override
    public Booking save(Booking entity) throws Exception {
        try {
            if (controlService.validate(entity)) {
                entity.setCreationDate(new Date());
                return super.save(entity);
            }throw new Exception("No permitido");
        } catch (Exception e) {
            throw new Exception("No permitido " + e.getMessage());
        }
    }
}
