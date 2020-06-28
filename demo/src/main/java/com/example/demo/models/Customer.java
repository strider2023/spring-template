package com.example.demo.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Document(collection="customer")
public class Customer {

    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private long customerNumber;
    @NotNull
    @Email
    private String email;
    private List<String> courseList;
    private float gpa;

    public Customer() {
    }

    public Customer(String id, String name, long customerNumber, String email, List<String> courseList, float gpa) {
        this.id = id;
        this.name = name;
        this.customerNumber = customerNumber;
        this.email = email;
        this.courseList = courseList;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<String> courseList) {
        this.courseList = courseList;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}