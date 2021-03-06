package com.agencia.fantur.service;

import com.agencia.fantur.model.*;
import com.agencia.fantur.model.Package;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PackageService extends BaseServiceImpl<Package, Long> {

    @Autowired
    ResidenceServiceImpl residenceService;
    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    ActivityServiceImpl activityService;
    @Autowired
    MedInsuranceService medicalInsurances;
    @Autowired
    PackageRepository packageRepository;

    boolean checkPackage(Long id) {
        Package p = packageRepository.findById(id).orElse(null);
        return p != null;
    }

    boolean checkUpdatePackage(Package p, Long id) {
        List<Ticket> tickets = p.getTickets();
        for (Ticket t : tickets) {
            Long tId = ticketService.getPackageId(t.getId());
            if (tId != null) {
                if (!tId.equals(id)) {
                    return false;
                }
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

    public boolean checkMedicalInsurance(MedicalInsurances m) {
        return medicalInsurances.checkMedInsurance(m.getId());
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
        if (p.getMedicalInsurances() != null) {
            if (!this.checkMedicalInsurance(p.getMedicalInsurances())) {
                throw new Exception("Seguros que no existen");
            }
        }

        return true;
    }


    public Double calculatePrice(Package p) {
        Double total = 0d;
        final double FEE = 1.20;
        for (Ticket t : p.getTickets()) {
            total += ticketService.findById(t.getId()).getPrice();
        }
        for (Activity a : p.getActivities()) {
            total += activityService.findById(a.getId()).getPrice();
        }
        total += residenceService.findById(p.getResidence().getId()).getPrice();
        total *= FEE;
        return total;
    }
    public Package update(Package p, Long id) throws Exception {
        try{
            if(!this.checks(p)) {
                throw new Exception();
            }
            if(!this.checkUpdatePackage(p,id)){
                throw new Exception("Tickets en otro paquete");
            }
            p.setPrice(this.calculatePrice(p));
            return super.update(p,id);
        }
        catch (Exception e){
            throw new Exception(e) ;
        }
    }
    public Package save(Package p) throws Exception {
        try {
            if (!this.checks(p)) {
                throw new Exception();
            }
            if (!this.checkPackageTickets(p)) {
                throw new Exception("LOS TICKETS EN OTRO PAQUETE");
            }
            p.setPrice(this.calculatePrice(p));
            return repository.save(p);
        } catch (Exception e) {
            System.out.println("-----ERROR-------");
            throw new Exception("No se pudo crear el paquete " + e.getMessage());
        }
    }

    public List<Package> findByCity(String city) {
        return packageRepository.findByCity(city);
    }

    public Set<Package> findByActivity(String activity) {
        return packageRepository.findByActivity(activity);
    }
}
