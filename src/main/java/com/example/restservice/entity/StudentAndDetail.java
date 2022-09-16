package com.example.restservice.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudentAndDetail {
    private Long  id;
    private String name;
    private Long height;
    private Long weigh;
    private String hobby;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getWeigh() {
        return weigh;
    }

    public void setWeigh(Long weigh) {
        this.weigh = weigh;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public StudentAndDetail(Long id, String name, Long height, Long weigh, String hobby) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weigh = weigh;
        this.hobby = hobby;
    }

    public StudentAndDetail() {
    }

    @Override
    public String toString() {
        return "StudentAndDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weigh=" + weigh +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
