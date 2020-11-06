package com.in28minutes.springboot.repository;

import com.in28minutes.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
