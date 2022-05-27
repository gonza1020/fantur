package com.agencia.fantur.service;

import com.agencia.fantur.model.City;
import com.agencia.fantur.model.user.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, Long>{
    boolean checkClient(Long id){
        Client c = repository.findById(id).orElse(null);
        return c != null;
    }
}
