package com.agencia.fantur.controller;

import com.agencia.fantur.model.Booking;
import com.agencia.fantur.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping()
    public ResponseEntity<List<Booking>> getAll() {
        return new ResponseEntity<>(bookingService.findAll(),HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<Booking> getById(Long id) {
        return new ResponseEntity<>(bookingService.findById(id),HttpStatus.OK);
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<Booking> update(Booking entity, Long id) throws Exception{
        return new ResponseEntity<>(bookingService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(Long id) {
        bookingService.delete(id);
    }
}
