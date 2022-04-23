package com.grf.library.service;

import com.grf.library.exception.BusinessException;
import com.grf.library.repository.model.StudentModel;

import java.util.List;

public interface StudentService {

    List<StudentModel> findAll() throws BusinessException;

    StudentModel getById(long id) throws BusinessException;

    StudentModel save(StudentModel studentModel) throws BusinessException;

    void deleteById(long id) throws BusinessException;

}
