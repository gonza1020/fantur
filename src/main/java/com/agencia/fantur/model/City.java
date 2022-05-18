package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "city")
public class City extends BaseEntity<Long>{

    @Column(name = "name",unique = true, nullable = false)
    private String name;
    @Column(name = "zipCode", nullable = false)
    private int zipCode;

}
