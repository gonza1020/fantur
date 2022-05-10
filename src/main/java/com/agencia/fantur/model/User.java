package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User extends BaseEntity<Long> {

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "user_name" , nullable = false)
    private String userName;
    @Column(name = "password" , nullable = false)
    private String password;
    @Column(name = "role_id" , nullable = false)
    private String roleId;
    @Column(name = "cuit", nullable = false)
    private long cuit;
    @Column(name = "phone", nullable = false)
    private long phone;
}
