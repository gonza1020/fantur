package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "premium_package")
public class PremiumPackage extends Package{

    private MedicalInsurances medicalInsurances;

    public MedicalInsurances addMedicalInsurance(MedicalInsurances medicalInsurances){
        this.medicalInsurances = medicalInsurances;
        return medicalInsurances;
    }

}
