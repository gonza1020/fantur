package com.agencia.fantur.service;


import com.agencia.fantur.model.*;
import com.agencia.fantur.model.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public abstract class PackageService<T extends BaseEntity> extends BaseServiceImpl<T, Long> {

    @Autowired
    ResidenceServiceImpl residenceService;
    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    ActivityServiceImpl activityService;

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


}
