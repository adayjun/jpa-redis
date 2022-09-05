package com.example.restservice.controller;

import com.example.restservice.entity.StudentAndDetail;
import com.example.restservice.entity.StudentDetail;
import com.example.restservice.service.StudentDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentDetailController {

    @Autowired
    private StudentDetailServiceImpl studentDetailServiceImpl;

    @GetMapping("/serachByHobby")
    public List<StudentDetail> serachByName(String hobby){

        List<StudentDetail> studentDetails =studentDetailServiceImpl.findByHobby(hobby);
        return studentDetails;
    }

    @GetMapping("/add")
    public StudentDetail add(Long stuId,Long height,Long weigh,String hobby){

        StudentDetail studentDetail=new StudentDetail();
        studentDetail.setHeight(height);
        studentDetail.setHobby(hobby);
        studentDetail.setStuId(stuId);
        studentDetail.setWeigh(weigh);
         StudentDetail studentDetail1 =studentDetailServiceImpl.add(studentDetail);
        return studentDetail1;
    }

    @GetMapping("/jilian")
    public List<StudentAndDetail> serachByjilian(String hobby){

        List<StudentAndDetail> ss =studentDetailServiceImpl.findStudentAndDetail(hobby);
        return ss;
    }

    @GetMapping("/searchByCon")
    public List<StudentDetail> searchByCon(String hobby,Long id){
        List<StudentDetail> sd=studentDetailServiceImpl.findByCon(hobby,id);
        return sd;

    }



}
