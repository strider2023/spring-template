package com.example.demo.services;

import com.example.demo.models.Customer;

import java.util.List;

public interface CustomerService {
    
    List<Customer> findAll();

    Customer findByCustomerNumber(long customerNumber);

    Customer findByEmail(String email);

    List<Customer> findAllByOrderByGpa();

    void saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(String id);
}