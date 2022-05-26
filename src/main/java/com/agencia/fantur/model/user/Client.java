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

