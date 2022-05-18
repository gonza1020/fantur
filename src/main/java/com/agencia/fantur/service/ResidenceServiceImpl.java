package com.agencia.fantur.service;

import com.agencia.fantur.exception.ResourceNotFoundException;
import com.agencia.fantur.model.City;
import com.agencia.fantur.model.Residence;
import com.agencia.fantur.repository.CityRepository;
import com.agencia.fantur.repository.ResidenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResidenceServiceImpl extends BaseServiceImpl<Residence,Long> {

    @Autowired
    CityServiceImpl cityService;
    @Autowired
    ResidenceRepository residenceRepository;
    public List<Residence> findByCity(String city){
        return residenceRepository.findByCity(city);
    }

    boolean checkResidence(Long id){
        Residence r = repository.findById(id).orElse(null);
        if(r != null){
            return true;
        }
        return false;
    }
    public Residence save(Residence r) throws Exception{
        try{
            if(cityService.checkCity(r.getCity().getId())){
                return repository.save(r);
            }
            throw new Exception("La ciudad no existe.");
        }
        catch (Exception e){
            throw e;
        }
    }


}
