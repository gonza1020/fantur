package com.agencia.fantur.service;

import com.agencia.fantur.model.City;
import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.repository.BaseRepository;
import com.agencia.fantur.repository.CityRepository;
import com.agencia.fantur.repository.TicketRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long> {
    @Autowired
    CityServiceImpl cityService;
    @Autowired
    TicketRepository ticketRepository;
    public List<Ticket> findByTo(String destiny){
        return ticketRepository.findByTo(destiny);
    }
    boolean checkTickets(Long id){
        Ticket t = repository.findById(id).orElse(null);
        if(t != null){
            return true;
        }
        return false;
    }
    public Ticket save(Ticket t) throws Exception {
        try{
            if(cityService.checkCity(t.getTo().getId()) && cityService.checkCity(t.getFrom().getId())){
                return repository.save(t);
            }
            throw new Exception("Verificar ciudades de destino u origen.");

        } catch (Exception e) {
            throw e;
        }

    }
}
