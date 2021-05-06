package com.example.exam.repositories;

import com.example.exam.models.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepositories extends CrudRepository<StudentEntity , Integer> {


}
