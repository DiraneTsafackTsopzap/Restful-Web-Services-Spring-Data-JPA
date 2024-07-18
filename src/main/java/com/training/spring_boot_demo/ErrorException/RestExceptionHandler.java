package com.training.spring_boot_demo.ErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.training.spring_boot_demo.Model.ErrorMessage;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        ErrorMessage message = new ErrorMessage();
        message.Status = HttpStatus.NOT_FOUND;
        message.Message = exception.getMessage();

        return message;
    }
}
