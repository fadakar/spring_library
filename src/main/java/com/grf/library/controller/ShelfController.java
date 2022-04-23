package com.grf.library.controller;

import com.grf.library.exception.BusinessException;
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
    public ResponseEntity<Object> list() throws BusinessException {
        return new ResponseEntity<Object>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable long id) throws BusinessException {
        ShelfModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity<Object>(model, HttpStatus.OK);
        } else {
            throw new BusinessException("Not Found Shelf", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> store(@RequestBody ShelfModel model) throws BusinessException {
        ShelfModel createdModel = service.save(model);
        return new ResponseEntity<Object>(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@RequestBody ShelfModel pathModel, @PathVariable long id) throws BusinessException {
        ShelfModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setShelfNO(pathModel.getShelfNO());
            foundModel.setFloor(pathModel.getFloor());
            foundModel.setDescription(pathModel.getDescription());
            return new ResponseEntity<Object>(service.save(foundModel), HttpStatus.OK);
        } else {
            throw new BusinessException("Not Found Shelf", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) throws BusinessException {
        ShelfModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
