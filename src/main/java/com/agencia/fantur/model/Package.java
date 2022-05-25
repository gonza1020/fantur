package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "package")
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Package extends BaseEntity<Long>  {

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(targetEntity = Ticket.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id",referencedColumnName = "id")
    private List<Ticket> tickets;


    @ManyToMany(targetEntity = Activity.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "package_activities", nullable = false,referencedColumnName = "id")
    private List<Activity> activities;

    // Should be many to one
    @OneToOne(targetEntity = Residence.class, fetch = FetchType.EAGER)
    private Residence residence;


}
