package com.example.restservice.service;

import com.example.restservice.entity.Student;
import com.example.restservice.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public Student add(Student s) {
        Student student = studentRepository.save(s);
        return student;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentEntities = studentRepository.findAll();
        return studentEntities;
    }

    @Override
    public Student findById(Long id) {

        String toString = stringRedisTemplate.opsForValue().get(id.toString());
        if (toString != null) {
            try {
                Student s = objectMapper.readValue(toString, new TypeReference<Student>() {
                });
                System.out.println("我是从缓存取出来的！！！！");
                return s;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }


        }

        System.out.println("================缓存是空的======================");
        //不在缓存 先查再塞

        Student s = new Student();
        Optional<Student> ss = studentRepository.findById(id);
        if (ss.isPresent()) {
            s = ss.get();
            try {
                stringRedisTemplate.opsForValue().set(id.toString(), objectMapper.writeValueAsString(s));
                System.out.println("我是从数据库取出来的！！");
                System.out.println("我第一次被塞进缓存了！！！！！！！！");
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return s;

        }
        return null;


    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> StudentEntities = studentRepository.findByName(name);
        return StudentEntities;
    }

    @Override
    public Page<Student> findALL(Pageable pageable) {

        Page<Student> ss = studentRepository.findALL(pageable);
        return ss;
    }
}