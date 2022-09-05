package com.example.restservice.service;

import com.example.restservice.entity.StudentAndDetail;
import com.example.restservice.entity.StudentDetail;

import java.util.List;

public interface StudentDetailService {

   /**
    * 增加一条记录
    * @param studentDetail
    * @return
    */
   StudentDetail add(StudentDetail studentDetail);

   /**
    * 通过hobby查询studentdetail表
    * @param hobby
    * @return
    */
   List<StudentDetail> findByHobby(String hobby);

   /**
    * 实现级联查询 两张表
    * @param hobby
    * @return
    */
   List<StudentAndDetail> findStudentAndDetail(String hobby);

   /**
    * 实现条件查询
    * @param hobby
    * @param id
    * @return
    */
   List<StudentDetail> findByCon(String hobby,Long id);


}
