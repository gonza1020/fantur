package com.agencia.fantur.service;

import com.agencia.fantur.interfaces.IPackage;
import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.Package;
import com.agencia.fantur.model.Residence;
import com.agencia.fantur.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService extends BaseServiceImpl<Package,Long> {

    @Autowired
    ResidenceServiceImpl residenceService;
    @Autowired
    TicketServiceImpl ticketService;
    @Autowired
    ActivityServiceImpl activityService;
    boolean checkTickets(List<Ticket> t){
        for (Ticket ticket:t) {
            if(!ticketService.checkTickets((ticket.getId()))){
                return false;
            }
        }
        return true;
    }
    boolean checkActivities(List<Activity> a){
        for (Activity act: a) {
            if(!activityService.checkActivity(act.getId())){
                return false;
            }
        }
        return true;
    }

    public Package save(Package p) throws Exception{
        try{
            if (!residenceService.checkResidence(p.getResidence().getId())){
                throw new Exception("No existe la residencia");
            }
            if(!this.checkTickets(p.getTickets())){
                throw new Exception("Estas agregando tickets que no existen.");
            }
            if(!this.checkActivities(p.getActivities())){
                throw new Exception("Actividades que no existen");
            }

            return repository.save(p);
        }
        catch (Exception e){
            throw e;
        }

    }

}
