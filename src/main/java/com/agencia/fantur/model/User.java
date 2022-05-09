package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "userName" , nullable = false)
    private String userName;
    @Column(name = "passsword" , nullable = false)
    private String password;
    @Column(name = "rollId" , nullable = false)
    private String rolId;
    @Column(name = "cuit", nullable = false)
    private long cuit;
    @Column(name = "phone", nullable = false)
    private long phone;
}
