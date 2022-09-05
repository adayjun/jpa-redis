package com.example.restservice.repository;

import com.example.restservice.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student>  findByName(String name);

    @Query("select s from Student s")
    Page<Student> findALL(Pageable pageable);

}
