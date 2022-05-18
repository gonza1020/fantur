package com.agencia.fantur.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PremiumPackage extends Package{
    @ManyToOne(targetEntity = MedicalInsurances.class)
    @JoinColumn(name = "insuranceId", nullable = false, referencedColumnName = "id")
    private List<MedicalInsurances> medicalInsurances;

/*    //Habria q crear el controller donde iria esto.
    public MedicalInsurances addMedicalInsurance(MedicalInsurances medicalInsurances){
        this.medicalInsurances.add(medicalInsurances);
        return medicalInsurances;
    }*/
}
