package com.agencia.fantur.controller;

import com.agencia.fantur.service.IGenericService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGenericController <T>{

    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> getById(@PathVariable Long id);
    public ResponseEntity<T> update(@RequestBody T entity, @PathVariable Long id);
    public void delete(@PathVariable Long id);
}
