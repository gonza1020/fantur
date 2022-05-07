package com.agencia.fantur.service;

import com.agencia.fantur.repository.IGenericRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


public class GenericService<T> implements IGenericService<T>{

    @Autowired
    private IGenericRepository<T> repository;


    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);

    }

    @Override
    public T findById(long id) {
        return repository.getById(id);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public T update(T entity, long id) {
        return null;
    }
}
