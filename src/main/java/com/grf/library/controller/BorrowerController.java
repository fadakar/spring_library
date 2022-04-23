package com.grf.library.controller;

import com.grf.library.repository.mapper.BorrowerMapper;
import com.grf.library.repository.model.BookModel;
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
    private BorrowerMapper borrowerMapper;

    @GetMapping("")
    public ResponseEntity list() {
        // TODO list book hayee ke gharz dade shode hastan ( ba ReturnDate == null )
        return null;
    }

    @GetMapping("book/{id}")
    public ResponseEntity show(@PathVariable long id) {
        // TODO show borrower status

        // namayesh vaziyat book ke dar ketab khane hast ya dar student
        // agar dar ketab khane bashat shelf return misheavd
        // agar dast kasti bashad student return mishavad

//        BookModel model = service.getById(id);
//        if (model != null) {
//            return new ResponseEntity(model, HttpStatus.OK);
//        } else {
//            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @PostMapping("")
    public ResponseEntity store(@RequestParam("bookId") long bookId, @RequestParam("studentId") long studentId) {
        // TODO insert borrower

        // student ra be book vasl mikonim ba insert new borrower record
//        BookModel createdModel = service.save(model);
//        return new ResponseEntity(createdModel, HttpStatus.CREATED);
        return null;
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public ResponseEntity update(@RequestBody BookModel model, @PathVariable long id) {
        // TODO update borrower

//        BookModel foundModel = service.getById(id);
//        if (foundModel != null) {
//            model.setId(foundModel.getId());
//            return new ResponseEntity(service.save(model), HttpStatus.OK);
//        } else {
//            return new ResponseEntity("Not Found Resource", HttpStatus.NOT_FOUND);
//        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        // TODO delete borrower
//        BookModel foundModel = service.getById(id);
//        if (foundModel.getId() == id) {
//            service.deleteById(id);
//        }
    }


}
