package com.agencia.fantur.service;

import com.agencia.fantur.model.Client;
import com.agencia.fantur.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client, Long>{

    @Autowired
    ClientRepository clientRepository;

}
