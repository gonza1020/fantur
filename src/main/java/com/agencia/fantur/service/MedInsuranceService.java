package com.agencia.fantur.service;

import com.agencia.fantur.model.MedicalInsurances;
import com.agencia.fantur.model.Package;
import com.agencia.fantur.model.Residence;
import org.springframework.stereotype.Service;

@Service
public class MedInsuranceService extends BaseServiceImpl<MedicalInsurances,Long>{

    boolean checkMedInsurance(Long id){
        MedicalInsurances r = repository.findById(id).orElse(null);
        return r != null;
    }
}
