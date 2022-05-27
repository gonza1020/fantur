package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseEntity<Long> {

    @Column(name = "balance", nullable = false)
    private Double balance;

}
