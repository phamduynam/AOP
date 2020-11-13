package com.in28minutes.springboot;


import com.in28minutes.springboot.config.ConfigAOP;
import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication

public class StudentServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentServicesApplication.class, args);

	}
}
