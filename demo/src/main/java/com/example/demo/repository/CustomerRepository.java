package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepository extends MongoRepository<Customer, String> {

  Customer findByCustomerNumber(long customerNumber);

  Customer findByEmail(String email);

  List<Customer> findAllByOrderByGpa();

  @Query(value="{}", fields="{ 'customerName' : 1, 'email' : 1}")
  List<Customer> findAllFiltered();
}