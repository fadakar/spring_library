package com.grf.library.controller;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.UserModel;
import com.grf.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService service;

    @GetMapping("")
    public ResponseEntity<Object> list() throws BusinessException {
        return new ResponseEntity<Object>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable long id) throws BusinessException {
        UserModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity<Object>(model, HttpStatus.OK);
        } else {
            throw new BusinessException("Not Found Student", HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("")
    public ResponseEntity<Object> store(@RequestBody UserModel model) throws BusinessException {
        UserModel createdModel = service.save(model);
        return new ResponseEntity<Object>(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@RequestBody UserModel pathModel, @PathVariable long id) throws BusinessException {
        UserModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setAdmin(pathModel.isAdmin());
            foundModel.setUsername(pathModel.getUsername());
            foundModel.setPassword(pathModel.getPassword());
            foundModel.setEmail(pathModel.getEmail());
            foundModel.setDescription(pathModel.getDescription());
            return new ResponseEntity<Object>(service.save(foundModel), HttpStatus.OK);
        } else {
            throw new BusinessException("Not Found Student", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) throws BusinessException {
        UserModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
