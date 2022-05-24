package com.agencia.fantur.model;

import com.agencia.fantur.model.user.Client;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity<Long>{

/*    @OneToOne
    private Client client;

    @OneToOne
    private Package aPackage;

    @Column(name = "creation_date")
    private Date creationDate;*/
     private Long cuit;
     private Date creationDate;
     private float price;

    //private Payment payment;


}
