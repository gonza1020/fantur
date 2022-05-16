package com.agencia.fantur.model;

import com.agencia.fantur.interfaces.IPackage;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public abstract class Package extends BaseEntity<Long> implements IPackage {

    @Column(name = "price", nullable = false)
    private Double price;

    private List<Ticket> tickets;

    private List<Activity> activities;

    private Residence residence;

    @Override
    public Activity addActivity(Activity activity) {
        activities.add(activity);
        return activity;
    }

    @Override
    public Residence addResidence(Residence residence) {
        this.residence = residence;
        return residence;
    }

    @Override
    public Ticket addTicket(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }
}
