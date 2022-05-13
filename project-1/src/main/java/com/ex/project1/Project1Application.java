package com.ex.project1;

import com.ex.project1.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}


	@Autowired
	EmployeeRepository employeeRepository;

	String response;
	/*
	@Bean
	CommandLineRunner runner() {
		return args -> {
			for(Transaction b : transactionRepository.findAll()) {
				System.out.println(b);
			}
		};

	}

*/


}
