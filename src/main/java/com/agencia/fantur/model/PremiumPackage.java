package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PremiumPackage extends Package{

    @ManyToOne(targetEntity = MedicalInsurances.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "insurance_Id", nullable = false)
    private MedicalInsurances medicalInsurances;

/*    //Habria q crear el controller donde iria esto.
    public MedicalInsurances addMedicalInsurance(MedicalInsurances medicalInsurances){
        this.medicalInsurances.add(medicalInsurances);
        return medicalInsurances;
    }*/
}
