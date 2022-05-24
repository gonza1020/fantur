package com.agencia.fantur.service;


import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.BaseEntity;
import com.agencia.fantur.repository.PackageRepository;
import com.agencia.fantur.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

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
        for (Ticket ticket : t) {
            if (!ticketService.checkTickets((ticket.getId()))) {
                return false;
            }
        }
        return true;
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
