package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EntityScan(basePackages = {"com/example/restservice/entity/StudentEntity.java"})
//@EnableJpaRepositories(basePackages = "com/example/restservice/repository/StudentRepository.java")
public class JpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}

}
