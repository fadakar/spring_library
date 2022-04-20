package com.grf.library.service;

import com.grf.library.repository.model.StudentModel;

import java.util.List;

public interface StudentService {

    List<StudentModel> findAll();

    StudentModel getById(long id);

    StudentModel save(StudentModel book);

    void deleteById(long id);

}
