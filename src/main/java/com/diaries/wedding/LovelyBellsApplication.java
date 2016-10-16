package com.diaries.wedding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.diaries.wedding.repository")
public class LovelyBellsApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(LovelyBellsApplication.class, args);
	}
	
	public void run() {
	}
}
