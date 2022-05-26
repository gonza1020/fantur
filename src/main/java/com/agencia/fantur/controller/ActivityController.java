package com.agencia.fantur.controller;

import com.agencia.fantur.model.Activity;
import com.agencia.fantur.service.BaseService;
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

    @PostMapping()
    @Override
    public ResponseEntity<Activity> create(Activity entity) throws Exception {
        try {
            return new ResponseEntity<>(activityService.save(entity), HttpStatus.CREATED);

        } catch (Exception e){
            throw e;
        }
    }

    @GetMapping()
    @Override
    public ResponseEntity<List<Activity>> getAll() {
        return new ResponseEntity<>(activityService.findAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<Activity> getById(@PathVariable Long id) {
        return new ResponseEntity<>(activityService.findById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    @Override
    public ResponseEntity<Activity> update(@RequestBody Activity entity,@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(activityService.update(entity,id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
        activityService.delete(id);
    }
}
