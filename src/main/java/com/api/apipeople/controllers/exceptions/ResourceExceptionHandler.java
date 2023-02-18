package com.api.apipeople.controllers.exceptions;

import com.api.apipeople.services.exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFound e, HttpServletRequest req){
        String error = "Resouce was not found.";
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(statusCode, error, e.getMessage());
        return ResponseEntity.status(statusCode).body(standardError);
    }

}
