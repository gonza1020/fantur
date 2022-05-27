package com.agencia.fantur.controller;

import com.agencia.fantur.model.MedicalInsurances;
import com.agencia.fantur.service.MedInsuranceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/insurance")
public class MedicalInsuranceController implements BaseController<MedicalInsurances,Long> {

    @Autowired
    MedInsuranceService medService;

    @Operation(summary = "Create a new medical insurance")
    @PostMapping()
    @Override
    public ResponseEntity<MedicalInsurances> create(@RequestBody  MedicalInsurances entity) throws Exception {
        return new ResponseEntity<>(medService.save(entity), HttpStatus.CREATED);

    }

    @Operation(summary = "Get all medical insurances")
    @GetMapping()
    @Override
    public ResponseEntity<List<MedicalInsurances>> getAll() {
        return new ResponseEntity<>(medService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a medical insurance by id")
    @GetMapping("{id}")
    @Override
    public ResponseEntity<MedicalInsurances> getById(@PathVariable  Long id) {
        return new ResponseEntity<>(medService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update a medical insurance by its id")
    @PutMapping("{id}")
    @Override
    public ResponseEntity<MedicalInsurances> update(@RequestBody MedicalInsurances entity, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(medService.update(entity, id), HttpStatus.ACCEPTED);

    }

    @Operation(summary = "Delete a medical insurance by its id")
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        medService.delete(id);
    }
}
