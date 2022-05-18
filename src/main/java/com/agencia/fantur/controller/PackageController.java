package com.agencia.fantur.controller;

import com.agencia.fantur.model.Package;
import com.agencia.fantur.model.PremiumPackage;
import com.agencia.fantur.model.StandardPackage;
import com.agencia.fantur.service.BaseService;
import com.agencia.fantur.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/packages")
public class PackageController{

    @Autowired
    private BaseService<Package,Long> packageService;

    @Autowired
    private BaseService<StandardPackage,Long> standardPackageService;

    @Autowired
    private BaseService<PremiumPackage,Long> premiumPackageService;

    @PostMapping("/standard")
    public ResponseEntity<StandardPackage> create(@RequestBody StandardPackage entity) {

            return new ResponseEntity<>(standardPackageService.save(entity), HttpStatus.CREATED);
    }

    @PostMapping("/premium")
    public ResponseEntity<PremiumPackage> create(@RequestBody PremiumPackage entity) {
        return new ResponseEntity<>(premiumPackageService.save(entity), HttpStatus.CREATED);
    }



    @GetMapping()
    public ResponseEntity<List<Package>> getAll() {
        return new ResponseEntity<>(packageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Package> getById(@PathVariable Long id) {
        return new ResponseEntity<>(packageService.findById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Package> update(Package entity, Long id) {
        return new ResponseEntity<>(packageService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        packageService.delete(id);
    }
}
