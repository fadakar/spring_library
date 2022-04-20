package com.grf.library.repository.mapper;

import com.grf.library.repository.entity.Student;
import com.grf.library.repository.model.StudentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student ModelToEntity(StudentModel studentModel);

    StudentModel EntityToModel(Student student);
}
