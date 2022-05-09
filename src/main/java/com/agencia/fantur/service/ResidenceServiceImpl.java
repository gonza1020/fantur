package com.agencia.fantur.service;

import com.agencia.fantur.exception.ResourceNotFoundException;
import com.agencia.fantur.model.Residence;
import org.springframework.stereotype.Service;


@Service
public class ResidenceServiceImpl extends BaseServiceImpl<Residence,Long> {
    public Residence findById(Long id) {
        return  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Residence","Long",id));
    }

    public Residence update(Residence entity, Long id) {

        Residence existingResidence = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Residence","Id",id));

        existingResidence.setDescription(entity.getDescription());
        existingResidence.setEnd(entity.getEnd());
        existingResidence.setPrice(entity.getPrice());
        existingResidence.setSince(entity.getSince());

        return repository.save(existingResidence);
    }
}
