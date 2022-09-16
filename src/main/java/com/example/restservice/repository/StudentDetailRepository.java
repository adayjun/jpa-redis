package com.example.restservice.repository;

import com.example.restservice.entity.StudentAndDetail;
import com.example.restservice.entity.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 可以实现级联查询
 */
public interface StudentDetailRepository extends JpaSpecificationExecutor<StudentDetail>, JpaRepository<StudentDetail,Long> {

    List<StudentDetail> findByHobby(String hobby);

    //@Query(value = "select new com.example.restservice.entity.StudentAndDetail(s.id as id,s.name as name,d.height as height,d.weigh as weigh,d.hobby as hobby ) from student s,studentdetail d " + "where s.id=d.stuid and d.hobby= ?1 ",nativeQuery = true)
    @Query(value = "select new com.example.restservice.entity.StudentAndDetail(s.id,s.name,d.height,d.weigh,d.hobby) from Student s,StudentDetail d " + "where s.id=d.stuId and d.hobby= ?1 ")
    List<StudentAndDetail> findStudentAndDetail(@Param("hobby") String hobby);

    @Query(value = "select u from StudentDetail u where hobby= ?1 and id> ?2")
    List<StudentDetail> findByCon(String hobby,Long id);



}
