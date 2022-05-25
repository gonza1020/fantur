package com.agencia.fantur.service;


import com.agencia.fantur.model.Ticket;
import com.agencia.fantur.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    boolean checkPackageTickets(Ticket t) {
        Ticket tck = ticketRepository.getPackageTickets(t.getId());
        return tck == null;
    }
    boolean checkTickets(Long id){
        Ticket t = ticketRepository.findById(id).orElse(null);
        return t != null;
    }

    boolean checkDates(Date departure,Date returnD){
        return departure.compareTo(returnD) < 0;
    }

    public Ticket save(Ticket t) throws Exception {
        try{
            if(cityService.checkCity(t.getTo().getId()) && cityService.checkCity(t.getFrom().getId())){
                if(checkDates(t.getDepartureDate(),t.getReturnDate())) {
                    return ticketRepository.save(t);
                }
                throw new Exception("Verificar fechas");
            }
                throw new Exception("Verificar ciudades de destino u origen.");

        } catch (Exception e) {
            throw new Exception("El ticket no pudo ser cargado. " + e.getMessage());
        }

    }
}
