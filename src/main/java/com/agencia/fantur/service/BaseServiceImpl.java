package com.agencia.fantur.service;


import com.agencia.fantur.model.BaseEntity;
import com.agencia.fantur.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.Serializable;
import java.util.List;



public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> implements BaseService<T, ID > {

    @Autowired
    BaseRepository<T, ID> repository;


    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
    @Override
    public T findById(ID id) { return  repository.findById(id).get(); }

    @Override
    public T save(T entity) throws Exception {
        return repository.save(entity);
    }

    @Override
    public T update(T entity, ID id) {
        T existingEntity = findById(id);
        entity.setId(id);
        existingEntity = repository.save(entity);
        return existingEntity;
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }

}
