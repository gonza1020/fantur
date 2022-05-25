package com.agencia.fantur.controller;

import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.service.PackageService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("api/packages/standard")
public class StandardPackageController implements BaseController<StandardPackage, Long> {


    @Autowired
    private PackageService<StandardPackage> standardPackageService;


    @Operation(summary = "Create a Standard Package")
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
    public ResponseEntity<StandardPackage> update(@RequestBody  StandardPackage entity, @PathVariable  Long id) throws Exception{
        return new ResponseEntity<>(standardPackageService.update(entity, id), HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a package by id")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        standardPackageService.delete(id);
    }

    // Busqueda con varios filtros de paquete
    //esto tendria que ir a generalpackage pero no le estoy haciendo funcionar jaja
    @Operation(summary = "Find a package by city")
    @GetMapping("city/{city}")
    public ResponseEntity<List<StandardPackage>> getAllPackagesByCity(@PathVariable String city) {
        return new ResponseEntity<>(standardPackageService.findByCity(city), HttpStatus.OK);
    }

    @Operation(summary = "Find a package by activity")
    @GetMapping("act/{act}")
    public ResponseEntity<Set<StandardPackage>> getPackageByActivity(@PathVariable String act){
        return new ResponseEntity<>(standardPackageService.findByActivity(act.toUpperCase()),HttpStatus.OK);
    }


}
