package com.agencia.fantur.controller;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activities")
public class ActivityController implements BaseController<Activity,Long> {

    @Autowired
    private BaseService<Activity,Long> activityService;

    @Operation(summary = "Create a new activity")
    @PostMapping()
    @Override
    public ResponseEntity<Activity> create(Activity entity) throws Exception {
        return new ResponseEntity<>(activityService.save(entity), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all activities")
    @GetMapping()
    @Override
    public ResponseEntity<List<Activity>> getAll() {
        return new ResponseEntity<>(activityService.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Get an activity by id")
    @GetMapping("{id}")
    @Override
    public ResponseEntity<Activity> getById(@PathVariable Long id) {
        return new ResponseEntity<>(activityService.findById(id),HttpStatus.OK);
    }

    @Operation(summary = "Update an activity by its id")
    @PutMapping("{id}")
    @Override
    public ResponseEntity<Activity> update(@RequestBody Activity entity,@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(activityService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Delete an activity by its id")
    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        activityService.delete(id);
    }
}
