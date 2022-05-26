package com.agencia.fantur.model;

import com.agencia.fantur.model.user.Client;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity<Long>{

     @ManyToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
     @JoinColumn(name = "client_id", nullable = false)
     private Client client;

     @OneToOne(targetEntity = Package.class, fetch = FetchType.EAGER)
     private Package aPackage;

     private float price;

    //private Payment payment;


}
