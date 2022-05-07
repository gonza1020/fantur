package com.agencia.fantur.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

public interface BaseController<T, ID extends Serializable>{

     ResponseEntity<T> create(@RequestBody T entity);
     ResponseEntity<List<T>> getAll();
     ResponseEntity<T> getById(@PathVariable ID id);
     ResponseEntity<T> update(@RequestBody T entity, @PathVariable ID id);
     void delete(@PathVariable ID id);
}
