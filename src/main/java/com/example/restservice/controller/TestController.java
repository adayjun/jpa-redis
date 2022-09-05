package com.example.restservice.controller;

import com.example.restservice.entity.Student;
import com.example.restservice.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {


    @Autowired
    private StudentServiceImpl studentServiceImpl;



    @GetMapping("/push")
    public List<Student> jpa(){
//        StudentEntity ss=new StudentEntity();
//        ss.setId(5L);
//        ss.setName("gang");
//        ss.setAge(22);
//        studentServiceImpl.add(ss);

        List<Student>  studentEntities=studentServiceImpl.findAll();
        return  studentEntities;


//        StudentEntity ss=new StudentEntity();
//        ss.setAge(19);
//        ss.setId(4L);
//        ss.setName("jjjjjjj");
//        studentRepositoryimpl.save(ss);
//        return "hhhhhh";

    }

    @GetMapping("/findById")
    public Student findById(Long id){
        Student ss=studentServiceImpl.findById(id);
        return ss;
    }

    @GetMapping("/insert")
    public Student insertStudent(String name, Long age){
        Student ss=new Student();
       // ss.setId(6L);
        ss.setName(name);
        ss.setAge(age);

        Student s=studentServiceImpl.add(ss);
        return  s;

    }


    @GetMapping("/searchbyname")
    public List<Student> seachStu(String name){
        List<Student> ss=studentServiceImpl.findByName(name);
       System.out.println("我被访问了！！！！");
        return ss;

    }

    @PostMapping("/fenye")
    public Page<Student> fenYe(Pageable pageable){
        Page<Student> ss=studentServiceImpl.findALL(pageable);
        return ss;
    }

}
