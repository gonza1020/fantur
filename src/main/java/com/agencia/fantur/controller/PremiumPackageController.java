package com.agencia.fantur.controller;

import com.agencia.fantur.model.PremiumPackage;
import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.service.PremiumPackageServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/packages/premium")
public class PremiumPackageController implements BaseController<PremiumPackage,Long>{

    @Autowired
    private PremiumPackageServiceImpl premiumPackageService;
    @Autowired
    private GeneralPackageController packageController;

    @Operation(summary = "Create a Premium Package")
    @PostMapping()
    public ResponseEntity<PremiumPackage> create(@RequestBody PremiumPackage entity) throws Exception{
        return new ResponseEntity<>(premiumPackageService.save(entity), HttpStatus.CREATED);
    }


    @Operation(summary = "Get all packages")
    @GetMapping()
    public ResponseEntity<List<PremiumPackage>> getAll() {
        return new ResponseEntity<>(premiumPackageService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a premium package by its id")
    @GetMapping("{id}")
    public ResponseEntity<PremiumPackage> getById(@PathVariable Long id) {
        return new ResponseEntity<>(premiumPackageService.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Update a package by its id")
    @PutMapping("{id}")
    public ResponseEntity<PremiumPackage> update(PremiumPackage entity, Long id) throws Exception {
        return new ResponseEntity<>(premiumPackageService.update(entity,id),HttpStatus.ACCEPTED);
    }
    // Busqueda con varios filtros de paquete

    @Operation(summary = "Delete a package by its id")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        premiumPackageService.delete(id);
    }


    @Operation(summary = "Find a premium package by city")
    @GetMapping("city/{city}")
    public ResponseEntity<List<PremiumPackage>> getAllPackagesByCity(@PathVariable String city) {
        return new ResponseEntity<>(premiumPackageService.findByCity(city), HttpStatus.OK);
    }

    @Operation(summary = "Find a premium package by activity")
    @GetMapping("act/{act}")
    public ResponseEntity<Set<PremiumPackage>> getPackageByActivity(@PathVariable String act){
        return new ResponseEntity<>(premiumPackageService.findByActivity(act.toUpperCase()),HttpStatus.OK);
    }
}
