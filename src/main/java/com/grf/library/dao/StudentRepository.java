package com.grf.library.dao;

import com.grf.library.entities.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    @Override
    List<Student> findAll();
}
