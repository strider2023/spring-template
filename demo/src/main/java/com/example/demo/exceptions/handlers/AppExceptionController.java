package com.example.demo.exceptions.handlers;

import com.example.demo.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionController {

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
        return new ResponseEntity<>("Customer not found.", HttpStatus.NOT_FOUND);
    }
}
