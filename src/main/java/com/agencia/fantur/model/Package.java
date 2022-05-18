package com.agencia.fantur.model;

import com.agencia.fantur.interfaces.IPackage;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "package")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Package extends BaseEntity<Long>  {

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(targetEntity = Ticket.class, fetch = FetchType.LAZY)
    @JoinTable(
            name = "package_ticket",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    private List<Ticket> tickets;


    @ManyToMany(targetEntity = Activity.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "package_activitie", nullable = false,referencedColumnName = "id")
    private List<Activity> activities;

    @OneToOne(targetEntity = Residence.class, fetch = FetchType.EAGER)
    private Residence residence;


}
