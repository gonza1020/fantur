package com.agencia.fantur.repository;

import com.agencia.fantur.model.MedicalInsurances;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface MedicalInsuranceRepository extends BaseRepository<MedicalInsurances, Long> {

}
