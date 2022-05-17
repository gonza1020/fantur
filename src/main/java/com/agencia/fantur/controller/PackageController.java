package com.agencia.fantur.controller;

import com.agencia.fantur.model.Package;
import com.agencia.fantur.service.BaseService;
import com.agencia.fantur.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
@RestController
@RequestMapping("api/packages")
public class PackageController implements BaseController <Package,Long>{

    @Autowired
    private BaseService<Package,Long> packageService;

    @PostMapping
    @Override
    public ResponseEntity<Package> create(@RequestBody Package entity) {
        return new ResponseEntity<>(packageService.save(entity), HttpStatus.CREATED);
    }

    /*@PostMapping
    public ResponseEntity<Package> createPackage (String from, String destiny){
        return new ResponseEntity<> (packageService.create(),HttpStatus.OK);
    }*/

    @GetMapping
    @Override
    public ResponseEntity<List<Package>> getAll() {
        return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<Package> getById(@PathVariable Long id) {
        return new ResponseEntity<>(packageService.findById(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Package> update(Package entity, Long aLong) {
        return null;
    }
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        packageService.delete(id);
    }
}
