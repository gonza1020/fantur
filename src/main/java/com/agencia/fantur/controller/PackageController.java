package com.agencia.fantur.controller;

import com.agencia.fantur.model.Package;
import com.agencia.fantur.service.PackageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/package")
public class PackageController implements BaseController<Package,Long>{


    @Autowired
    PackageService packageService;

    @GetMapping()
    public ResponseEntity<List<Package>> getAllPackages() {
        return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Find a package by city")
    @GetMapping("city/{city}")
    public ResponseEntity<List<Package>> getAllPackagesByCity(@PathVariable String city) {
        return new ResponseEntity<>(packageService.findByCity(city), HttpStatus.OK);
    }

    @Operation(summary = "Find a package by activity")
    @GetMapping("act/{act}")
    public ResponseEntity<Set<Package>> getPackageByActivity(@PathVariable String act){
        return new ResponseEntity<>(packageService.findByActivity(act.toUpperCase()),HttpStatus.OK);
    }


    @Override
    @PostMapping
    public ResponseEntity<Package> create(Package entity) throws Exception {
        return new ResponseEntity<>(packageService.save(entity),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Package>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Package> getById(Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Package> update(Package entity, Long aLong) throws Exception {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
