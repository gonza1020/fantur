package com.agencia.fantur.model.user;

import com.agencia.fantur.enums.Role;
import com.agencia.fantur.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public abstract class User extends BaseEntity<Long> {

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

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


    @Column(name = "phone", nullable = false)
    private long phone;
}
