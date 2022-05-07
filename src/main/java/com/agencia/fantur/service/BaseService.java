package com.agencia.fantur.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable>{

    List<T> findAll();
    T save(T entity);
    T findById(ID id);
    void delete(ID id);
    T update(T entity, ID id);
}
