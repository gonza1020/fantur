package com.agencia.fantur.controller;

import com.agencia.fantur.model.MedicalInsurances;
import com.agencia.fantur.service.MedInsuranceService;
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
    @PostMapping()
    @Override
    public ResponseEntity<MedicalInsurances> create(@RequestBody  MedicalInsurances entity) throws Exception {
        return new ResponseEntity<>(medService.save(entity), HttpStatus.CREATED);

    }
    @GetMapping()
    @Override
    public ResponseEntity<List<MedicalInsurances>> getAll() {
        return new ResponseEntity<>(medService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    @Override
    public ResponseEntity<MedicalInsurances> getById(@PathVariable  Long id) {
        return new ResponseEntity<>(medService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Override
    public ResponseEntity<MedicalInsurances> update(@RequestBody MedicalInsurances entity, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(medService.update(entity, id), HttpStatus.ACCEPTED);

    }
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        medService.delete(id);
    }
}
