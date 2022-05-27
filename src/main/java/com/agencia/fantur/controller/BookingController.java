package com.agencia.fantur.controller;

import com.agencia.fantur.model.Booking;
import com.agencia.fantur.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create a new booking")
    @Override
    @PostMapping()
    public ResponseEntity<Booking> create(Booking entity) throws Exception {
        return new ResponseEntity<>(bookingService.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all bookings")
    @Override
    @GetMapping()
    public ResponseEntity<List<Booking>> getAll() {
        return new ResponseEntity<>(bookingService.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Get a booking by id")
    @Override
    @GetMapping("{id}")
    public ResponseEntity<Booking> getById(Long id) {
        return new ResponseEntity<>(bookingService.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Update a booking by its id")
    @Override
    @PutMapping("{id}")
    public ResponseEntity<Booking> update(Booking entity, Long id) throws Exception{
        return new ResponseEntity<>(bookingService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a booking by its id")
    @Override
    @DeleteMapping("{id}")
    public void delete(Long id) {
        bookingService.delete(id);
    }
}
