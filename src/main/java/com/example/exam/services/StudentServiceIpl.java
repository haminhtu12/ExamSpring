package com.example.exam.services;

import com.example.exam.dto.StudentDto;
import com.example.exam.models.StudentEntity;
import com.example.exam.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceIpl implements StudentService{
    @Autowired
    StudentRepositories studentRepository;

//    @Override
//    public StudentEntity  save( StudentDto s) {
//        return studentRepository.save(s);
//    }

    @Override
    public StudentEntity save(StudentEntity s) {
        return studentRepository.save(s);
    }

    @Override
    public Optional<StudentEntity> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Iterable<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }}
