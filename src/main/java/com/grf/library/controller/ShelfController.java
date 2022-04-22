package com.grf.library.controller;

import com.grf.library.repository.model.ShelfModel;
import com.grf.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shelf")
public class ShelfController {

    @Autowired
    @Qualifier("shelfServiceImpl")
    private ShelfService service;

    @GetMapping("")
    public ResponseEntity list() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable long id) {
        ShelfModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity(model, HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity store(@RequestBody ShelfModel model) {
        ShelfModel createdModel = service.save(model);
        return new ResponseEntity(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity update(@RequestBody ShelfModel pathModel, @PathVariable long id) {
        ShelfModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setShelfNO(pathModel.getShelfNO());
            foundModel.setFloor(pathModel.getFloor());
            foundModel.setDescription(pathModel.getDescription());
            return new ResponseEntity(service.save(foundModel), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        ShelfModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
