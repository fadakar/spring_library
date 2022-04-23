package com.grf.library.controller;

import com.grf.library.repository.mapper.ShelfMapper;
import com.grf.library.repository.model.BookModel;
import com.grf.library.repository.model.ShelfModel;
import com.grf.library.service.BookService;
import com.grf.library.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService service;

    @Autowired
    @Qualifier("shelfServiceImpl")
    private ShelfService shelfService;

    @Autowired
    private ShelfMapper shelfMapper;

    @GetMapping("")
    public ResponseEntity list() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity show(@PathVariable long id) {
        BookModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity(model, HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity store(@RequestBody BookModel model) {
        BookModel createdModel = service.save(model);
        return new ResponseEntity(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity update(@RequestBody BookModel model, @PathVariable long id) {
        BookModel foundModel = service.getById(id);
        if (foundModel != null) {
            model.setId(foundModel.getId());
            return new ResponseEntity(service.save(model), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        BookModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


}
