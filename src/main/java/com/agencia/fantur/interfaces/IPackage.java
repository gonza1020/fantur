package com.agencia.fantur.interfaces;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.model.Residence;
import com.agencia.fantur.model.Ticket;

public interface IPackage {
    Activity addActivity(Activity activity);
    Ticket addTicket(Ticket ticket);
    Residence addResidence(Residence residence);
}
