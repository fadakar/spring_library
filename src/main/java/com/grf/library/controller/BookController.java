package com.grf.library.controller;

import com.grf.library.dao.BookRepository;
import com.grf.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping("")
    public List<Book> list() {
        return bookRepo.findAll();
    }

    @GetMapping(path = "", params = {"page", "size"})
    public Iterable<Book> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return bookRepo.findAll(paging);
    }


    @GetMapping("/{id}")
    public Book show(@PathVariable long id) {
        Optional<Book> found = bookRepo.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Book store(@RequestBody Book Book) {
        bookRepo.save(Book);
        return Book;
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Book update(@RequestBody Book patchBook, @PathVariable long id) {
        Optional<Book> found = bookRepo.findById(id);
        if (found.isPresent()) {
            Book book = found.get();
            book.setTitle(patchBook.getTitle());
            book.setShelf(patchBook.getShelf());
            book.setCategory(patchBook.getCategory());
            book.setLanguage(patchBook.getLanguage());
            book.setPublicationYear(patchBook.getPublicationYear());
            book.setDescription(patchBook.getDescription());
            return bookRepo.save(book);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        Optional<Book> found = bookRepo.findById(id);
        if (found.isPresent() && found.get().getId() == id) {
            bookRepo.deleteById(id);
        }
    }


}
