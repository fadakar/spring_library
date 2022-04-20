package com.grf.library.service.impl;

import com.grf.library.repository.StudentRepository;
import com.grf.library.repository.entity.Student;
import com.grf.library.repository.mapper.StudentMapper;
import com.grf.library.repository.model.StudentModel;
import com.grf.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repo;

    @Autowired
    StudentMapper mapper;

    @Override
    public List<StudentModel> findAll() {
        List<Student> students = repo.findAll();
        List<StudentModel> studentModels = new ArrayList<>();
        for (Student student : students) {
            studentModels.add(mapper.EntityToModel(student));
        }
        return studentModels;
    }

    @Override
    public StudentModel getById(long id) {
        Student student = repo.getById(id);
        if (student != null) {
            return mapper.EntityToModel(student);
        } else {
            return null;
        }
    }

    @Override
    public StudentModel save(StudentModel studentModel) {
        Student student = mapper.ModelToEntity(studentModel);
        Student savedStudent = repo.save(student);
        return mapper.EntityToModel(savedStudent);
    }

    @Override
    public void deleteById(long id) {
        Student foundStudent = repo.getById(id);
        if (foundStudent != null) {
            repo.deleteById(foundStudent.getId());
        }
    }
}
