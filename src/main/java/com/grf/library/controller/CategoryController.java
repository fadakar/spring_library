package com.grf.library.controller;

import com.grf.library.repositories.CategoryRepository;
import com.grf.library.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;

    @GetMapping("")
    public List<Category> list() {
        return categoryRepo.findAll();
    }

    @GetMapping(path = "", params = {"page", "size"})
    public Iterable<Category> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return categoryRepo.findAll(paging);
    }


    @GetMapping("/{id}")
    public Category show(@PathVariable long id) {
        Optional<Category> found = categoryRepo.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Category store(@RequestBody Category category) {
        return categoryRepo.save(category);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Category update(@RequestBody Category patchCategory, @PathVariable long id) {
        Optional<Category> found = categoryRepo.findById(id);
        if (found.isPresent()) {
            Category category = found.get();
            category.setTitle(patchCategory.getTitle());
            category.setDescription(patchCategory.getDescription());
            return categoryRepo.save(category);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        Optional<Category> found = categoryRepo.findById(id);
        if (found.isPresent() && found.get().getId() == id) {
            categoryRepo.deleteById(id);
        }
    }


}
