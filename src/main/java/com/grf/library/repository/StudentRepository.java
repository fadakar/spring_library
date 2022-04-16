package com.grf.library.repository;

import com.grf.library.repository.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Override
    List<Student> findAll();
}
