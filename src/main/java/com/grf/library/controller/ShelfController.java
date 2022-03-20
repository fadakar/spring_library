package com.grf.library.controller;

import com.grf.library.dao.ShelfRepository;
import com.grf.library.entities.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shelf")
public class ShelfController {

    @Autowired
    private ShelfRepository shelfRepo;

    @GetMapping("")
    public List<Shelf> list() {
        return shelfRepo.findAll();
    }

    @GetMapping(path = "", params = {"page", "size"})
    public Iterable<Shelf> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return shelfRepo.findAll(paging);
    }


    @GetMapping("/{id}")
    public Shelf show(@PathVariable long id) {
        Optional<Shelf> found = shelfRepo.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Shelf store(@RequestBody Shelf user) {
        shelfRepo.save(user);
        return user;
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Shelf update(@RequestBody Shelf patchShelf, @PathVariable long id) {
        Optional<Shelf> found = shelfRepo.findById(id);
        if (found.isPresent()) {
            Shelf shelf = found.get();
            shelf.setShelfNO(patchShelf.getShelfNO());
            shelf.setFloor(patchShelf.getFloor());
            shelf.setDescription(patchShelf.getDescription());
            return shelfRepo.save(shelf);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        Optional<Shelf> found = shelfRepo.findById(id);
        if (found.isPresent() && found.get().getId() == id) {
            shelfRepo.deleteById(id);
        }
    }


}
