package com.agencia.fantur.controller;

import com.agencia.fantur.model.City;
import com.agencia.fantur.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cities")
public class CityController implements BaseController<City,Long>{

    @Autowired
    private BaseService<City,Long> cityService;

    @PostMapping()
    @Override
    public ResponseEntity<City> create(City entity) {
        return new ResponseEntity<>(cityService.save(entity), HttpStatus.CREATED);
    }

    @GetMapping()
    @Override
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(cityService.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<City> getById(Long id) {
        return new ResponseEntity<>(cityService.findById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Override
    public ResponseEntity<City> update(City entity, Long id) {
        return new ResponseEntity<>(cityService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Override
    public void delete(Long id) {
        cityService.delete(id);
    }
}
