package com.training.spring_boot_demo.ErrorException;

public class EmployeeNotFoundException extends RuntimeException{


    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
