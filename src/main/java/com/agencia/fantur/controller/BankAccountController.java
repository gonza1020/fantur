package com.agencia.fantur.controller;

import com.agencia.fantur.model.BankAccount;
import com.agencia.fantur.service.BaseService;
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

    @Override
    @PostMapping()
    public ResponseEntity<BankAccount> create(BankAccount entity) throws Exception {
        return new ResponseEntity<>(bankAccountService.save(entity), HttpStatus.CREATED);
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<BankAccount>> getAll() {
        return new ResponseEntity<>(bankAccountService.findAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<BankAccount> getById(Long id) {
        return new ResponseEntity<>(bankAccountService.findById(id),HttpStatus.OK);
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<BankAccount> update(BankAccount entity, Long id) throws Exception {
        return new ResponseEntity<>(bankAccountService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Override
    @DeleteMapping("{id}")
    public void delete(Long id) {
        bankAccountService.delete(id);
    }
}
