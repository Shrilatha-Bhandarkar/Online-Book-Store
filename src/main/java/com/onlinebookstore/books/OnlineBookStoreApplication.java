package com.onlinebookstore.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

//Main entry point for the Online Book Store application.

@SpringBootApplication // Enables Spring Boot's auto-configuration, component scanning, and configuration support
public class OnlineBookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBookStoreApplication.class, args); // Runs the Spring Boot application
		
		System.out.println("Welcome to Online Book Store Application!");
	}
	
}
