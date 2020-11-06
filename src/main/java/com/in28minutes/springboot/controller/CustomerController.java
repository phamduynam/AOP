package com.in28minutes.springboot.controller;

import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.Response;
import com.in28minutes.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/list")
    public List<Customer> getCustomersList(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{cusId}")
    public ResponseEntity getCustomerById(@PathVariable("cusId") Integer id){
        Customer customer = customerService.getCustomerById(id);
        if( customer!= null){
            return ResponseEntity.ok().body(customer);
        }
        return (ResponseEntity) ResponseEntity.notFound();
    }

    // Có thể tạo thêm class feedback để mô tả thông tin trả về
    @GetMapping("/customer/delete/{cusId}")
    public List<Customer> deleteCustomerById(@PathVariable("cusId") Integer id){
        return customerService.deleteCustomerById(id);
    }

    @PostMapping("/customer/update/{Cusid}")
    public Customer updateCustomer(Customer customer, @PathVariable("Cusid") Integer id){
        return customerService.updateCustomer(customer,id);
    }

}
