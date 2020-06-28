package com.example.demo.services.implementation;

import java.util.List;

import com.example.demo.models.Customer;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    MongoTemplate mongoTemplate;

    @Autowired
    public CustomerServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Customer> findAll() {
        // VARIANT 1
        Query query = new Query();
        query.fields()
                .include("name")
                .include("email")
                .exclude("id");
        // return this.mongoTemplate.find(query, Customer.class);

        // VARIANT 2
        // http://jongo.org/#query-templating
        // mongoTemplate.projection("{name:#",1)

        // VARIANT 3
        return customerRepository.findAllFiltered();
    }

    @Override
    public Customer findByCustomerNumber(long customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public List<Customer> findAllByOrderByGpa() {
        return customerRepository.findAllByOrderByGpa();
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}