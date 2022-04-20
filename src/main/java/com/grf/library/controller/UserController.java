package com.grf.library.controller;

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
    public ResponseEntity list() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable long id) {
        UserModel model = service.getById(id);
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity store(@RequestBody UserModel userModel) {
        UserModel createdModel = service.save(userModel);
        return new ResponseEntity(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity update(@RequestBody UserModel pathModel, @PathVariable long id) {
        UserModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setAdmin(pathModel.isAdmin());
            foundModel.setUsername(pathModel.getUsername());
            foundModel.setPassword(pathModel.getPassword());
            foundModel.setEmail(pathModel.getEmail());
            foundModel.setDescription(pathModel.getDescription());
            return new ResponseEntity(service.save(foundModel), HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        UserModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
