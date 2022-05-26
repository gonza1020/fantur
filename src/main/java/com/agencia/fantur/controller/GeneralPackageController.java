package com.agencia.fantur.controller;

import com.agencia.fantur.model.Package;
import com.agencia.fantur.repository.PackageRepositoryImpl;
import com.agencia.fantur.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/package")
public class GeneralPackageController {


    @Autowired
    PackageRepositoryImpl packageService;

    @GetMapping()
    public ResponseEntity<List<Package>> getAllPackages() {
        return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
    }
/*
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

*/
}
