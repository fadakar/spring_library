package com.grf.library.controller;

import com.grf.library.exception.BusinessException;
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
    public ResponseEntity<Object> list() throws BusinessException {
        return new ResponseEntity<Object>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable long id) throws BusinessException {
        StudentModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity<Object>(model, HttpStatus.OK);
        } else {
            throw new BusinessException("Not Found Student", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> store(@RequestBody StudentModel model) throws BusinessException {
        StudentModel createdModel = service.save(model);
        return new ResponseEntity<Object>(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@RequestBody StudentModel pathModel, @PathVariable long id) throws BusinessException{
        StudentModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setFirstName(pathModel.getFirstName());
            foundModel.setLastName(pathModel.getLastName());
            foundModel.setBirthday(pathModel.getBirthday());
            foundModel.setCellphone(pathModel.getCellphone());
            foundModel.setTelephone(pathModel.getTelephone());
            foundModel.setGender(pathModel.getGender());
            return new ResponseEntity<Object>(service.save(foundModel), HttpStatus.OK);
        } else {
            throw new BusinessException("Not Found Student", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) throws BusinessException {
        StudentModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
