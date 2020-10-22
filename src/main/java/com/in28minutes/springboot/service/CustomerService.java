package com.in28minutes.springboot.service;

import com.in28minutes.springboot.model.Customer;
import com.in28minutes.springboot.model.Response;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerService {
    public static List<Customer> listCustomer = new ArrayList<>();

    static {
        Customer customer_1 = new Customer(1,"Nam",23,"nam@gmail.com");
        listCustomer.add(customer_1);
    }

    public Customer createNewCustomer(Customer customer){
        int idCustomerEnd = listCustomer.get(listCustomer.size() - 1).getId();
        customer.setId(idCustomerEnd + 1);
        listCustomer.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomer(){
        return listCustomer;
    }

    public Customer getCustomerById(Integer id){
        for(Customer customer : listCustomer){
            if(id.equals(customer.getId()) ){
                return customer;
            }
        }
        return null;
    }

    public Response deleteCustomerById(Integer id){
        for(Customer customer : listCustomer){
            if(id.equals(customer.getId())){
                listCustomer.remove(customer);
                return new Response( true);
            }
        }
        return new Response(false);
    }

}
