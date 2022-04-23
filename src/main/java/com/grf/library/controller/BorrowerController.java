package com.grf.library.controller;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.mapper.BorrowerMapper;
import com.grf.library.repository.model.BorrowerModel;
import com.grf.library.service.BookService;
import com.grf.library.service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    @Qualifier("borrowerServiceImpl")
    private BorrowerService service;

    @Autowired
    @Qualifier("bookServiceImpl")
    BookService bookService;

    @Autowired
    private BorrowerMapper borrowerMapper;

    @GetMapping("")
    public ResponseEntity<Object> list() throws BusinessException {
        return new ResponseEntity<Object>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable long id) throws BusinessException {
        BorrowerModel model = service.getById(id);
        if (model != null) {
            return new ResponseEntity<Object>(model, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("Not Found Borrower", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> store(@RequestBody BorrowerModel model) throws BusinessException {
        BorrowerModel createdModel = service.save(model);
        return new ResponseEntity<Object>(createdModel, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity<Object> update(@RequestBody BorrowerModel model, @PathVariable long id) throws BusinessException {
        BorrowerModel foundModel = service.getById(id);
        if (foundModel != null) {
            model.setId(foundModel.getId());
            return new ResponseEntity<Object>(service.save(model), HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>("Not Found Borrower", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) throws BusinessException {
        BorrowerModel foundModel = service.getById(id);
        if (foundModel.getId() == id) {
            service.deleteById(id);
        }
    }


    @GetMapping("/{id}/status")
    public ResponseEntity<Object> status(@PathVariable long id) throws BusinessException {
        return new ResponseEntity<Object>(this.bookService.getStatus(id), HttpStatus.OK);
    }

}
