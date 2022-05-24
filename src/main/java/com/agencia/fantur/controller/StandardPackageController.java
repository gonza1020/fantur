package com.agencia.fantur.controller;

import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.service.PackageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/packages/standard")
public class StandardPackageController implements BaseController<StandardPackage, Long> {


    @Autowired
    private PackageService<StandardPackage> standardPackageService;


    @Operation(summary = "Create a Premium Package")
    @PostMapping()
    public ResponseEntity<StandardPackage> create(@RequestBody StandardPackage entity) throws Exception {
        return new ResponseEntity<>(standardPackageService.save(entity), HttpStatus.CREATED);
    }


    @Operation(summary = "Get all packages")
    @GetMapping()
    public ResponseEntity<List<StandardPackage>> getAll() {
        return new ResponseEntity<>(standardPackageService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get package by id")
    @GetMapping("{id}")
    public ResponseEntity<StandardPackage> getById(@PathVariable Long id) {
        return new ResponseEntity<>(standardPackageService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Update a package by id")
    @PutMapping("{id}")
    public ResponseEntity<StandardPackage> update(StandardPackage entity, Long id) {
        return new ResponseEntity<>(standardPackageService.update(entity, id), HttpStatus.ACCEPTED);
    }
    // Busqueda con varios filtros de paquete

    @Operation(summary = "Delete a package by id")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        standardPackageService.delete(id);
    }

    @Operation(summary = "Find a package by city")
    @GetMapping("city/{city}")
    public ResponseEntity<List<StandardPackage>> getAllPackagesByCity(@PathVariable String city) {
        return new ResponseEntity<>(standardPackageService.findByCity(city), HttpStatus.OK);
    }
}