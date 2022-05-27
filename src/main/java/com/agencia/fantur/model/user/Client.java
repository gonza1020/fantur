package com.agencia.fantur.model.user;


import com.agencia.fantur.model.BankAccount;
import com.agencia.fantur.model.Residence;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client extends User {

    @Column(name = "cuit", nullable = false)
    private long cuit;

    @OneToOne(targetEntity = BankAccount.class, fetch = FetchType.EAGER)
    private BankAccount bankAccount;
}

