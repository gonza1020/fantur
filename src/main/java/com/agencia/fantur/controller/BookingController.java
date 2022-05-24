package com.agencia.fantur.controller;

import com.agencia.fantur.model.Booking;
import com.agencia.fantur.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/booking")
public class BookingController implements BaseController<Booking,Long> {

    @Autowired
    BookingService bookingService;

    @Override
    @PostMapping()
    public ResponseEntity<Booking> create(Booking entity) throws Exception {
        return new ResponseEntity<>(bookingService.save(entity), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Booking>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Booking> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Booking> update(Booking entity, Long aLong) throws Exception{
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
