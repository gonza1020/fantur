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

    @Operation(summary = "Get packages by city")
    @GetMapping("city/{city}")
    public ResponseEntity<List<Package>> getAllPackagesByCity(@PathVariable String city) {
        return new ResponseEntity<>(packageService.findByCity(city), HttpStatus.OK);
    }

    @Operation(summary = "Get packages by activity")
    @GetMapping("act/{act}")
    public ResponseEntity<Set<Package>> getPackageByActivity(@PathVariable String act){
        return new ResponseEntity<>(packageService.findByActivity(act.toUpperCase()),HttpStatus.OK);
    }

    @Operation(summary = "Create a new package")
    @Override
    @PostMapping()
    public ResponseEntity<Package> create(Package entity) throws Exception {
        return new ResponseEntity<>(packageService.save(entity),HttpStatus.CREATED);
    }

    @Operation(summary = "Get all packages")
    @Override
    @GetMapping()
    public ResponseEntity<List<Package>> getAll() {
        return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a package by id")
    @Override
    @GetMapping("{id}")
    public ResponseEntity<Package> getById(Long id) {
        return new ResponseEntity<>(packageService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update a package by its id")
    @Override
    @PutMapping("{id}")
    public ResponseEntity<Package> update(Package entity, Long id) throws Exception {
        return new ResponseEntity<>(packageService.update(entity, id), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a package by its id")
    @Override
    @DeleteMapping("{id}")
    public void delete(Long id) {
        packageService.delete(id);
    }
}
