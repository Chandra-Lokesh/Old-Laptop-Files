package com.ust.simple.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleProjectApplication {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(SimpleProjectApplication.class, args);
	}

}
