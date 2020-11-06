package com.in28minutes.springboot;

import com.in28minutes.springboot.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication

public class StudentServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);
	}
}
