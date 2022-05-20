package com.agencia.fantur.controller;

import com.agencia.fantur.model.City;
import com.agencia.fantur.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create a new city")
    @PostMapping()
    @Override
    public ResponseEntity<City> create(City entity) throws Exception {
        return new ResponseEntity<>(cityService.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all cities")
    @GetMapping()
    @Override
    public ResponseEntity<List<City>> getAll() {
        return new ResponseEntity<>(cityService.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Get city by id")
    @GetMapping("{id}")
    @Override
    public ResponseEntity<City> getById(Long id) {
        return new ResponseEntity<>(cityService.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Update a city by its id")
    @PutMapping("{id}")
    @Override
    public ResponseEntity<City> update(City entity, Long id) {
        return new ResponseEntity<>(cityService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a city by its id")
    @DeleteMapping("{id}")
    @Override
    public void delete(Long id) {
        cityService.delete(id);
    }
}
