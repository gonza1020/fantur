package com.agencia.fantur.controller;

import com.agencia.fantur.model.Residence;
import com.agencia.fantur.service.ResidenceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/residence")
public class ResidenceController implements BaseController<Residence,Long> {

    @Autowired
    ResidenceServiceImpl residence;

    @Operation(summary = "Create a new residence")
    @PostMapping()
    @Override
    public ResponseEntity<Residence> create( @RequestBody Residence entity) throws Exception {
        return new ResponseEntity<>(residence.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all residences")
    @GetMapping()
    @Override
    public ResponseEntity<List<Residence>> getAll() {
        return new ResponseEntity<>(residence.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a residence by id")
    @GetMapping("{id}")
    @Override
    public ResponseEntity<Residence> getById(@PathVariable  Long id) {
        return new ResponseEntity<>(residence.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Get residences by city")
    @GetMapping({"city/{destiny}"})
    public ResponseEntity<List<Residence>> findByDestiny(@PathVariable String destiny){
        return new ResponseEntity<>(residence.findByCity(destiny),HttpStatus.OK);
    }

    @Operation(summary = "Update a residence by its id")
    @PutMapping("{id}")
    @Override
    public ResponseEntity<Residence> update(@RequestBody  Residence entity, @PathVariable  Long id) throws Exception{
        return new ResponseEntity<>(residence.update(entity, id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a residence by its id")
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        residence.delete(id);
    }
}
