package com.example.restservice.service;

import com.example.restservice.entity.StudentAndDetail;
import com.example.restservice.entity.StudentDetail;
import com.example.restservice.repository.StudentDetailRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class StudentDetailServiceImpl implements StudentDetailService {

    @Autowired
    private StudentDetailRepository studentDetailRepository;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public StudentDetail add(StudentDetail studentDetail) {
        StudentDetail s = studentDetailRepository.save(studentDetail);
        return s;
    }

    @Override
    public List<StudentDetail> findByHobby(String hobby) {

        String toString = stringRedisTemplate.opsForValue().get(hobby);
        if (toString != null) {
            try {
                List<StudentDetail> ss = objectMapper.readValue(toString, new TypeReference<List<StudentDetail>>() {});
                System.out.println("我是从缓存里取出来的！！！！！！！！！！！！！！！！！！");
                return ss;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        //缓存为空，先查，再塞进缓存
        List<StudentDetail> ss=studentDetailRepository.findByHobby(hobby);;
        if(ss.size()!=0){
            try {
                stringRedisTemplate.opsForValue().set(hobby,objectMapper.writeValueAsString(ss));
                System.out.println("我第一次被塞进缓存了啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return ss;
        }
        return null;


    }

    @Override
    public List<StudentAndDetail> findStudentAndDetail(String hobby) {
        List<StudentAndDetail> studentAndDetail = studentDetailRepository.findStudentAndDetail(hobby);
        return studentAndDetail;
    }

    @Override
    public List<StudentDetail> findByCon(String hobby, Long id) {
        List<StudentDetail> sd = studentDetailRepository.findByCon(hobby, id);
        return sd;
    }
}
