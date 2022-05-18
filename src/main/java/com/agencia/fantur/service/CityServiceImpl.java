package com.agencia.fantur.service;

import com.agencia.fantur.model.City;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl extends BaseServiceImpl<City,Long>{

    boolean checkCity(Long id){
        City c = repository.findById(id).orElse(null);
        if(c != null){
            return true;
        }
        return false;
    }

}
