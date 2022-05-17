package com.agencia.fantur.service;

import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.repository.TicketRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long> {

    TicketRepository repository;
   public ResponseEntity<Ticket> getByDestiny(String destiny){
       return new ResponseEntity<>(repository.getByDestiny(destiny), HttpStatus.OK);
   }

}
