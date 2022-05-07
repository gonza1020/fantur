package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "cuit", nullable = false)
    private long cuit;
    @Column(name = "phone", nullable = false)
    private long phone;
}
