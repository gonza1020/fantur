package com.agencia.fantur.service;


import com.agencia.fantur.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;
import java.util.List;



public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID > {

    @Autowired
    BaseRepository<T, ID> repository;



    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(ID id) {
        return repository.getById(id);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T update(T entity, ID id) {
        return null;
    }
}
