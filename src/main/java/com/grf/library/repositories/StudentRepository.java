package com.grf.library.repositories;

import com.grf.library.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    List<Student> findAll();
}
