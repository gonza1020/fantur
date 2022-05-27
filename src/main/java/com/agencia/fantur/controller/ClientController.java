package com.agencia.fantur.controller;

import com.agencia.fantur.model.user.Client;
import com.agencia.fantur.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create a new client")
    @PostMapping()
    public ResponseEntity<Client> create(@RequestBody Client entity) throws Exception {
        return new ResponseEntity<>(clientService.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all clients")
    @GetMapping()
    @Override
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Get a client by id")
    @GetMapping("{id}")
    @Override
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Delete a client by its id")
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }

    @Operation(summary = "Update a client by its id")
    @PutMapping("{id}")
    @Override
    public ResponseEntity<Client> update(@RequestBody Client entity, @PathVariable Long id) throws Exception{
        return new ResponseEntity<>(clientService.update(entity, id), HttpStatus.OK);
    }
}
