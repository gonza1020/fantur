package com.agencia.fantur.service;

import com.agencia.fantur.model.Residence;
import com.agencia.fantur.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class ResidenceServiceImpl extends BaseServiceImpl<Residence,Long> {
    @Autowired
    ResidenceRepository residenceRepository;

}
