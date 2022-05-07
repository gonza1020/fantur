package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_name", nullable = false)
    private String email;
    @Column(name = "cuit_name", nullable = false)
    private long cuit;
    @Column(name = "phone_name", nullable = false)
    private long phone;
}
