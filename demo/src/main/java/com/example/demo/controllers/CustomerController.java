package com.example.demo.controllers;

import java.util.List;

import com.example.demo.exceptions.CustomerNotFoundException;
import com.example.demo.services.CustomerService;
import com.example.demo.models.Customer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Customers API")
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public List<Customer> getAllCustomers() {
//        throw new CustomerNotFoundException();
        return customerService.findAll();
    }

    @GetMapping(value = "/{customerNumber}")
    public Customer getCustomersByCustomersNumber(@PathVariable("customerNumber") Long customerNumber) {
        return customerService.findByCustomerNumber(customerNumber);
    }

    @GetMapping(value = "/{email}")
    public Customer getCustomersByEmail(@PathVariable("email") String email) {
        return customerService.findByEmail(email);
    }

     @GetMapping(value = "/orderByGpa")
     public List<Customer> findAllByOrderByGpaDesc() {
         return customerService.findAllByOrderByGpa();
     }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateCustomer(@RequestBody Customer customer) {
        customerService.saveOrUpdateCustomer(customer);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{customerNumber}")
    public void deleteCustomers(@PathVariable Long customerNumber) {
        customerService.deleteCustomer(customerService.findByCustomerNumber(customerNumber).getId());
    }
}