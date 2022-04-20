package com.grf.library.controller;

import com.grf.library.repository.model.StudentModel;
import com.grf.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService service;

    @GetMapping("")
    public ResponseEntity list() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable long id) {
        StudentModel model = service.getById(id);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity store(@RequestBody StudentModel model) {
        StudentModel createdModel = service.save(model);
        return new ResponseEntity(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity update(@RequestBody StudentModel pathModel, @PathVariable long id) {
        StudentModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setFirstName(pathModel.getFirstName());
            foundModel.setLastName(pathModel.getLastName());
            foundModel.setBirthday(pathModel.getBirthday());
            foundModel.setCellphone(pathModel.getCellphone());
            foundModel.setTelephone(pathModel.getTelephone());
            foundModel.setGender(pathModel.getGender());
            return new ResponseEntity(service.save(foundModel), HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        StudentModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
