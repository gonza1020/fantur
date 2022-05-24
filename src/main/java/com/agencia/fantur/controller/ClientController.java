package com.agencia.fantur.controller;

import com.agencia.fantur.model.user.Client;
import com.agencia.fantur.model.user.User;
import com.agencia.fantur.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController implements BaseController<Client, Long> {

    @Autowired
    BaseService<Client, Long> clientService;

    @PostMapping()
    public ResponseEntity<Client> create(@RequestBody Client entity) throws Exception {
        return new ResponseEntity<>(clientService.save(entity), HttpStatus.CREATED);
    }

    @GetMapping()
    @Override
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Override
    public ResponseEntity<Client> update(@RequestBody Client entity, @PathVariable Long id) {
        return new ResponseEntity<>(clientService.update(entity, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }
}
