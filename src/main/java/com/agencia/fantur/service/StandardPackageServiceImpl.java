package com.agencia.fantur.service;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.model.Ticket;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;


@Service
public class StandardPackageServiceImpl extends PackageService<StandardPackage> {


    public boolean checks(StandardPackage p) throws Exception{
      return super.checks(p);
    }

    /*Double calculatePrice(StandardPackage p) {
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
    }*/
    public StandardPackage update(StandardPackage p, Long id) throws Exception {
        try{
            if(!this.checks(p)) {
                throw new Exception();
            }
            p.setPrice(super.calculatePrice(p));
            return super.update(p,id);
        }
        catch (Exception e){
            throw new Exception(e) ;
        }
    }
    public StandardPackage save(StandardPackage p) throws Exception {
        try {
            if(!this.checks(p)) {
                throw new Exception();
            }
            p.setPrice(super.calculatePrice(p));
            return repository.save(p);
        } catch (Exception e) {
            System.out.println("-----ERROR-------"+p.getPrice());
            throw new Exception("No se pudo crear el paquete " + e.getMessage());
        }

    }

}
