package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "package")
public  class Package extends BaseEntity<Long>  {

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToMany(targetEntity = Ticket.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id",referencedColumnName = "id")
    private List<Ticket> tickets;

    @ManyToMany(targetEntity = Activity.class , fetch = FetchType.EAGER)
    @JoinColumn(name = "package_activities", nullable = false,referencedColumnName = "id")
    private List<Activity> activities;

    @OneToOne(targetEntity = Residence.class, fetch = FetchType.EAGER)
    private Residence residence;

    @ManyToOne(targetEntity = MedicalInsurances.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_Id",columnDefinition="integer")
    private MedicalInsurances medicalInsurances;

}
