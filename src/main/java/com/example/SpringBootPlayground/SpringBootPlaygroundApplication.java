package com.example.SpringBootPlayground;

import com.example.SpringBootPlayground.dao.TeilnehmerRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootPlaygroundApplication.class, args);
	}



}
