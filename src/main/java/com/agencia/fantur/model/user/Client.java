package com.agencia.fantur.model.user;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "client")
public class Client extends User {

    @Column(name = "cuit", nullable = false)
    private long cuit;
}


/*
       '{
        "cuit": 20284435215,
        "fecha_incio": "2022-04-23T11:11:43.7635-03:00",
        "fecha_fin": "2022-04-23T11:11:43.7635-03:00",
        "precio": 10000
        }'*/
