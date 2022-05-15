package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="medicalInsurances")
public class MedicalInsurances extends BaseEntity<Long>{

    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "type", nullable = false)
    private String type;
}
