package com.agencia.fantur.controller;

import com.agencia.fantur.model.Residence;
import com.agencia.fantur.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/residence")
public class ResidenceController implements BaseController<Residence,Long> {

    @Autowired
    BaseService<Residence, Long> residenceService;

    @PostMapping()
    @Override
    public ResponseEntity<Residence> create( @RequestBody Residence entity) {
        return new ResponseEntity<>(residenceService.save(entity), HttpStatus.CREATED);
    }
    @GetMapping()
    @Override
    public ResponseEntity<List<Residence>> getAll() {
        return new ResponseEntity<>(residenceService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    @Override
    public ResponseEntity<Residence> getById(@PathVariable  Long id) {
        return new ResponseEntity<>(residenceService.findById(id), HttpStatus.OK);
    }
    @PutMapping("{id}")
    @Override
    public ResponseEntity<Residence> update(@RequestBody  Residence entity, @PathVariable  Long id) {
        return new ResponseEntity<>(residenceService.update(entity, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        residenceService.delete(id);
    }
}
