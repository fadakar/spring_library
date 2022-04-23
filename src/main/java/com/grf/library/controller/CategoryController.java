package com.grf.library.controller;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.CategoryModel;
import com.grf.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    @Qualifier("categoryServiceImpl")
    private CategoryService service;

    @GetMapping("")
    public ResponseEntity list() throws BusinessException {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable long id) throws BusinessException {
        CategoryModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity(model, HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity store(@RequestBody CategoryModel model) throws BusinessException {
        CategoryModel createdModel = service.save(model);
        return new ResponseEntity(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity update(@RequestBody CategoryModel pathModel, @PathVariable long id) throws BusinessException {
        CategoryModel foundModel = service.getById(id);
        if (foundModel != null) {
            foundModel.setTitle(pathModel.getTitle());
            foundModel.setDescription(pathModel.getDescription());
            return new ResponseEntity(service.save(foundModel), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) throws BusinessException {
        CategoryModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
