package com.agencia.fantur.controller;

import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.service.BaseService;
import com.agencia.fantur.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Tickets")
public class TicketController implements BaseController<Ticket,Long>{

    //ticketService tendria que ser de la clase BaseServiceImpl pero tira error.
    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping
    @Override
    public ResponseEntity<Ticket> create(@RequestBody Ticket entity) {
        return new ResponseEntity<>(ticketService.save(entity), HttpStatus.CREATED);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Ticket>> getAll() {
        return new ResponseEntity<>(ticketService.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.findById(id),HttpStatus.OK);
    }

    @GetMapping("{destiny}")
    public ResponseEntity<> getByDestiny (@PathVariable String destiny){
        return new ResponseEntity<>(ticketService.getByDestiny(destiny),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Ticket> update(Ticket entity, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long id) {
        ticketService.delete(id);
    }
}
