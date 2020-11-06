package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.Response;
import com.in28minutes.springboot.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerService {
    @Autowired
    private ICustomerRepository customerRepository;


    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer id) throws NullPointerException{
        return customerRepository.findById(id).get();
    }

    public List<Customer> deleteCustomerById(Integer id){
        Customer customer = getCustomerById(id);
        customerRepository.deleteById(customer.getId());
        return customerRepository.findAll();
    }
    public Customer updateCustomer(Customer customer, Integer id){
       Customer findCustomer = getCustomerById(id);
        if(customer.getId() == findCustomer.getId()){
            customerRepository.save(customer);
        }
        return getCustomerById(id);
    }

}
