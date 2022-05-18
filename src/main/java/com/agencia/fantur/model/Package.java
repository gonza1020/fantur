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

    @OneToMany(targetEntity = Ticket.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "packageId", nullable = false, referencedColumnName = "id")
    private List<Ticket> tickets;


    @ManyToMany(targetEntity = Activity.class , cascade = CascadeType.ALL)
    @JoinColumn(name = "package_activitie", nullable = false,referencedColumnName = "id")
    private List<Activity> activities;

    @OneToOne(targetEntity = Residence.class, cascade = CascadeType.ALL)
    private Residence residence;


}
