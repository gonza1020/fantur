package com.agencia.fantur.service;

import com.agencia.fantur.model.MedicalInsurances;
import com.agencia.fantur.model.PremiumPackage;
import org.springframework.stereotype.Service;

@Service
public class MedInsuranceService extends BaseServiceImpl<MedicalInsurances,Long>{

    public boolean checkMedInsurance(PremiumPackage p ) {
        MedicalInsurances m = repository.findById(p.getMedicalInsurances().getId()).orElse(null);
        return m != null;
    }
}
