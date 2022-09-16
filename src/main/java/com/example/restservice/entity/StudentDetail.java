package com.example.restservice.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="studentdetail")
public class StudentDetail {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "stuid")
    private Long stuId;

    private Long height;

    private Long weigh;

    private String hobby;

}
