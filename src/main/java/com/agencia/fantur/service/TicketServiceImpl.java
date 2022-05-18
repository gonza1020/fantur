package com.agencia.fantur.service;

import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.repository.TicketRepository;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long> {

}
