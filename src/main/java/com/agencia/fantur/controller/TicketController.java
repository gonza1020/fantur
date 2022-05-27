package com.agencia.fantur.controller;

import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.service.TicketServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketController implements BaseController<Ticket,Long>{


    @Autowired
    TicketServiceImpl ticket;

    @Operation(summary = "Create a new ticket")
    @PostMapping()
    @Override
    public ResponseEntity<Ticket> create(@RequestBody Ticket entity) throws Exception {
        return new ResponseEntity<>(ticket.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all tickets")
    @GetMapping()
    @Override
    public ResponseEntity<List<Ticket>> getAll() {
        return new ResponseEntity<>(ticket.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Get a ticket by id")
    @GetMapping("{id}")
    @Override
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        return new ResponseEntity<>(ticket.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Get tickets by destiny")
    @RequestMapping(value="/destiny/{destiny}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> findByDestiny(@PathVariable String destiny){
        return new ResponseEntity<>(ticket.findByTo(destiny),HttpStatus.OK);
    }

    @Operation(summary = "Update a ticket by its id")
    @PutMapping("{id}")
    @Override
    public ResponseEntity<Ticket> update(@RequestBody Ticket entity, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(ticket.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a ticket by its id")
    @DeleteMapping()
    @Override
    public void delete(Long id) {
        ticket.delete(id);
    }
}
