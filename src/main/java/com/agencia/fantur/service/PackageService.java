package com.agencia.fantur.service;

import com.agencia.fantur.model.*;
import com.agencia.fantur.model.Package;
import com.agencia.fantur.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public  class PackageService<T extends BaseEntity> extends BaseServiceImpl<T, Long> {

    @Autowired
    ResidenceServiceImpl residenceService;
    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    ActivityServiceImpl activityService;

    @Autowired
    PackageRepository<T> packageRepository;

    public boolean checkResidence (Residence r ) {
        return residenceService.checkResidence(r.getId());
    }
    public boolean checkTickets(List<Ticket> t) {
        for (Ticket ticket : t) {
            if (!ticketService.checkTickets((ticket.getId()))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkActivities(List<Activity> a) {
        for (Activity act : a) {
            if (!activityService.checkActivity(act.getId())) {
                return false;
            }
        }
        return true;
    }

    boolean checks (Package p) throws Exception{
        if (!this.checkResidence(p.getResidence())) {
            throw new Exception("No existe la residencia");
        }
        if (!this.checkTickets(p.getTickets())) {
            throw new Exception("Estas agregando tickets que no existen.");
        }
        if (!this.checkActivities(p.getActivities())) {
            throw new Exception("Actividades que no existen");
        }
        return true;
    }


    public Double calculatePrice (Package p) {
            Double total = 0d;
            final Double fee = 1.20;
            for (Ticket t : p.getTickets()) {
                total += ticketService.findById(t.getId()).getPrice();
            }
            for (Activity a : p.getActivities()) {
                total += activityService.findById(a.getId()).getPrice();
            }
            total += residenceService.findById(p.getResidence().getId()).getPrice();
            total *= fee;
            return  total;
    }



    public List<T> findByCity(String city){
        return packageRepository.findByCity(city);
    }

    public Set<T> findByActivity(String activity) {
        return packageRepository.findByActivity(activity);
    }


}
