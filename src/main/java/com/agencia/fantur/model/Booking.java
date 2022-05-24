package com.agencia.fantur.model;

import com.agencia.fantur.model.user.Client;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity<Long>{

    @OneToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    private Client client;

    @OneToOne(targetEntity = StandardPackage.class, fetch = FetchType.EAGER)
    private StandardPackage aPackage;

    @Column(name = "creation_date")
    private Date creationDate;

    //private Payment payment;


}
