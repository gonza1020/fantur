package com.agencia.fantur.service;


import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.BaseEntity;
import com.agencia.fantur.model.City;
import com.agencia.fantur.repository.PackageRepository;
import com.agencia.fantur.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public abstract class PackageService<T extends BaseEntity> extends BaseServiceImpl<T, Long> {

    @Autowired
    ResidenceServiceImpl residenceService;
    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    ActivityServiceImpl activityService;

    @Autowired
    PackageRepository<T> packageRepository;


    boolean checkTickets(List<Ticket> t) {
        if (!ticketService.checkTickets(t.get(0).getId())) {
            return false;
        }
        Ticket firstTicket = ticketService.findById(t.get(0).getId());
        for (Ticket ticket : t) {
            if (!ticketService.checkTickets((ticket.getId()))) {
                return false;
            } else {
                ticket = ticketService.findById(ticket.getId());
                if (compareTickets(ticket, firstTicket)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean compareTickets(Ticket t1, Ticket t2){
        return !t1.getReturnDate().equals(t2.getReturnDate()) || !t1.getDepartureDate().equals(t2.getDepartureDate()) ||
                !t1.getFrom().equals(t2.getFrom()) || !t1.getTo().equals(t2.getTo()) || !t1.getTicketType().equals(t2.getTicketType());
    }

    boolean checkActivities(List<Activity> a) {
        for (Activity act : a) {
            if (!activityService.checkActivity(act.getId())) {
                return false;
            }
        }
        return true;
    }

    public List<T> findByCity(String city){
        return packageRepository.findByCity(city);
    }

}
