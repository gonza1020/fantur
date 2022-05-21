package com.agencia.fantur.service;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.model.Ticket;
import org.springframework.stereotype.Service;


@Service
public class StandardPackageServiceImpl extends PackageService<StandardPackage> {


    Double calculatePrice(StandardPackage p) {
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

    public StandardPackage save(StandardPackage p) throws Exception {
        try {
            if (!residenceService.checkResidence(p.getResidence().getId())) {
                throw new Exception("No existe la residencia");
            }
            if (!this.checkTickets(p.getTickets())) {
                throw new Exception("Estas agregando tickets que no existen.");
            }
            if (!this.checkActivities(p.getActivities())) {
                throw new Exception("Actividades que no existen");
            }
            p.setPrice(this.calculatePrice(p));
            return repository.save(p);
        } catch (Exception e) {
            throw new Exception("No se pudo crear el paquete " + e.getMessage());
        }

    }

}
