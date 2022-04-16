package com.grf.library.controller;

import com.grf.library.repository.UserRepository;
import com.grf.library.repository.entity.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired

    @GetMapping("")
    public ResponseEntity list() {
        return new ResponseEntity(userRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "", params = {"page", "size"})
    public Iterable<User> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return userRepo.findAll(paging);
    }


    @GetMapping("/{id}")
    public User show(@PathVariable long id) {
        Optional<User> found = userRepo.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User store(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public User update(@RequestBody User patchUser, @PathVariable long id) {
        Optional<User> found = userRepo.findById(id);
        if (found.isPresent()) {
            User user = found.get();
            user.setAdmin(patchUser.isAdmin());
            user.setUsername(patchUser.getUsername());
            user.setPassword(patchUser.getPassword());
            user.setEmail(patchUser.getEmail());
            user.setDescription(patchUser.getDescription());
            return userRepo.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        Optional<User> found = userRepo.findById(id);
        if (found.isPresent() && found.get().getId() == id) {
            userRepo.deleteById(id);
        }
    }


}
