package com.agencia.fantur.service;

import java.util.List;

public interface IGenericService <T>{

    List<T> findAll();
    T save(T entity);
    T findById(long id);
    void delete(long id);
    T update(T entity, long id);
}
