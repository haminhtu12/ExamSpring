package com.example.exam.services;

import com.example.exam.dto.StudentDto;
import com.example.exam.models.StudentEntity;

import java.util.Optional;

public interface StudentService {
    StudentEntity save( StudentEntity s);

    Optional<StudentEntity> findById(Integer id);

    Iterable<StudentEntity> findAll();

    void deleteById(Integer id);

    void deleteAll();
}
