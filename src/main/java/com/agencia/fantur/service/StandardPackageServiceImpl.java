package com.agencia.fantur.service;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.model.Ticket;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Service
public class StandardPackageServiceImpl extends PackageService<StandardPackage> {


    Double calculatePrice(StandardPackage p) {
        String strDouble;
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
    public StandardPackage update(StandardPackage p, Long id) throws Exception {
        try{
             if (!super.checkResidence(p.getResidence())) {
                throw new Exception("No existe la residencia");
            }
            if (!super.checkTickets(p.getTickets())) {
                throw new Exception("Estas agregando tickets que no existen.");
            }
            if (!super.checkActivities(p.getActivities())) {
                throw new Exception("Actividades que no existen");
            }
            p.setPrice(this.calculatePrice(p));
            return super.update(p,id);
        }
        catch (Exception e){
            throw new Exception(e) ;
        }
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
            System.out.println("-----ERROR-------"+p.getPrice());
            throw new Exception("No se pudo crear el paquete " + e.getMessage());
        }

    }

}
