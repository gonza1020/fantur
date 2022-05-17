package com.agencia.fantur.interfaces;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.Residence;
import com.agencia.fantur.model.Ticket;

public interface IPackage {
    Activity addActivity(Activity a);
    Ticket addTicket(Ticket t);
    Residence addResidence(Residence r );
}
