package com.example.restservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class Student {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private Long age;


}
