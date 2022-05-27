package com.agencia.fantur.service;

import com.agencia.fantur.model.*;
import com.agencia.fantur.model.Package;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.BaseEntity;
import com.agencia.fantur.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PackageService<T extends BaseEntity> extends BaseServiceImpl<T, Long> {

    @Autowired
    ResidenceServiceImpl residenceService;
    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    ActivityServiceImpl activityService;

    @Autowired
    PackageRepository<T> packageRepository;

    boolean checkPackage(Long id){
        T p = repository.findById(id).orElse(null);
        return p != null;
    }
    boolean checkUpdatePackage(Package p) {
        List<Ticket> tickets = p.getTickets();
        for (Ticket t: tickets) {
            Long tId = ticketService.getPackageId(t.getId());
            if(tId != p.getId()){
                return false;
            }
        }
        return true;
    }
    public boolean checkPackageTickets(Package p) {
        List<Ticket> tickets = p.getTickets();
        for (Ticket t : tickets) {
            if (!ticketService.checkPackageTickets(t)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkResidence(Residence r) {
        return residenceService.checkResidence(r.getId());
    }

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
                if (compareTickets(ticket, firstTicket)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean compareTickets(Ticket t1, Ticket t2) {
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

    boolean checks(Package p) throws Exception {
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


    public Double calculatePrice(Package p) {
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
        return total;
    }


    public List<T> findByCity(String city) {
        return packageRepository.findByCity(city);
    }

    public Set<T> findByActivity(String activity) {
        return packageRepository.findByActivity(activity);
    }

    //public Set<T> findAllPackages () { return packageRepository.findAllPackage();}

}
