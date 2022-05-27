package com.agencia.fantur.controller;

import com.agencia.fantur.model.BankAccount;
import com.agencia.fantur.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bankAccount")
public class BankAccountController implements BaseController<BankAccount, Long> {

    @Autowired
    private BaseService<BankAccount, Long> bankAccountService;

    @Operation(summary = "Create a new bank account")
    @Override
    @PostMapping()
    public ResponseEntity<BankAccount> create(BankAccount entity) throws Exception {
        return new ResponseEntity<>(bankAccountService.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all bank accounts")
    @Override
    @GetMapping()
    public ResponseEntity<List<BankAccount>> getAll() {
        return new ResponseEntity<>(bankAccountService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a bank account by id")
    @Override
    @GetMapping("{id}")
    public ResponseEntity<BankAccount> getById(Long id) {
        return new ResponseEntity<>(bankAccountService.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Update a bank account by its id")
    @Override
    @PutMapping("{id}")
    public ResponseEntity<BankAccount> update(BankAccount entity, Long id) throws Exception {
        return new ResponseEntity<>(bankAccountService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete a bank account by its id")
    @Override
    @DeleteMapping("{id}")
    public void delete(Long id) {
        bankAccountService.delete(id);
    }
}
