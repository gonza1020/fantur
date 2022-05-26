package com.agencia.fantur.controller;

import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.service.TicketServiceImpl;
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

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket entity) throws Exception {
        System.out.println("TICKETT" + entity);
        return new ResponseEntity<>(ticket.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAll() {
        return new ResponseEntity<>(ticket.findAll(),HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        return new ResponseEntity<>(ticket.findById(id),HttpStatus.OK);
    }

    @RequestMapping(value="/destiny/{destiny}", method = RequestMethod.GET)
    public ResponseEntity<List<Ticket>> findByDestiny(@PathVariable String destiny){
        return new ResponseEntity<>(ticket.findByTo(destiny),HttpStatus.OK);
    }


    public ResponseEntity<Ticket> update(Ticket entity, Long aLong) {
        return null;
    }


    public void delete(Long id) {
        ticket.delete(id);
    }
}
