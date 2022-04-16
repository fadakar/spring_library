package com.grf.library.controller;

import com.grf.library.repository.StudentRepository;
import com.grf.library.repository.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("")
    public List<Student> list() {
        return studentRepo.findAll();
    }

    @GetMapping(path = "", params = {"page", "size"})
    public Iterable<Student> list(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable paging = PageRequest.of(page, size);
        return studentRepo.findAll(paging);
    }


    @GetMapping("/{id}")
    public Student show(@PathVariable long id) {
        Optional<Student> found = studentRepo.findById(id);
        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Student store(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Student update(@RequestBody Student patchStudent, @PathVariable long id) {
        Optional<Student> found = studentRepo.findById(id);
        if (found.isPresent()) {
            Student student = found.get();
            student.setFirstName(patchStudent.getFirstName());
            student.setLastName(patchStudent.getLastName());
            student.setBirthday(patchStudent.getBirthday());
            student.setCellphone(patchStudent.getCellphone());
            student.setTelephone(patchStudent.getTelephone());
            student.setGender(patchStudent.getGender());
            return studentRepo.save(student);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable long id) {
        Optional<Student> found = studentRepo.findById(id);
        if (found.isPresent() && found.get().getId() == id) {
            studentRepo.deleteById(id);
        }
    }


}
