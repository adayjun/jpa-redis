package com.example.restservice.service;

import com.example.restservice.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    Student add(Student s);
    List<Student> findAll();

    Student findById(Long id);
    List<Student> findByName(String name);

    Page<Student>  findALL(Pageable pageable);

}
