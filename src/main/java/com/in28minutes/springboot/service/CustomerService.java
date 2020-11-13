package com.in28minutes.springboot.service;

import com.in28minutes.springboot.dto.CustomerInternationalizationDto;
import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.Response;
import com.in28minutes.springboot.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
@Service
@PropertySource("classpath:meassages_en.properties")
public class CustomerService {

    @Autowired
    private Environment environment;

    @Autowired
    @Value("#{${nameMap}}")
    private Map<Integer,String> listNameEn;

    @Autowired
    private MessageSource source;
    @Autowired
    private ICustomerRepository customerRepository;


    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public CustomerInternationalizationDto getCustomerById(Integer id) throws NullPointerException{
        Customer customer =  customerRepository.findById(id).get();
        CustomerInternationalizationDto customerResult = new CustomerInternationalizationDto();
        customerResult.setId(customer.getId());
        customerResult.setAge(customer.getAge());
        customerResult.setEmail(customer.getEmail());
        customerResult.setName_VN(customer.getName());
        
        customerResult.setName_EN(this.listNameEn.get(customer.getId()));
        // có 2 cách lấy nameEN của customer
        // Cách 1: Environment
//        System.out.println(environment.getProperty("nameMap"));
        // Cách 2: @Value()
//        System.out.println(this.listNameEn);

//        System.out.println(customerResult.toString());

        return customerResult;
    }

//    public List<Customer> deleteCustomerById(Integer id){
//        Customer customer = getCustomerById(id);
//        customerRepository.deleteById(customer.getId());
//        return customerRepository.findAll();
//    }
    public Customer updateCustomer(Customer customer, Integer id) throws NullPointerException{
       Customer findCustomer = customerRepository.findById(id).get();
        if(customer.getId() == findCustomer.getId()){
            customerRepository.save(customer);
        }
        return customerRepository.findById(id).get();
    }

}
