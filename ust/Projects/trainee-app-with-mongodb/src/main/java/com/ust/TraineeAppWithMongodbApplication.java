package com.ust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraineeAppWithMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraineeAppWithMongodbApplication.class, args);
		System.out.println("Started");
	}

}
