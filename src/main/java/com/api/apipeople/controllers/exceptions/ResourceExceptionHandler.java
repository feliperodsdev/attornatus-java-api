package com.api.apipeople.controllers.exceptions;

import com.api.apipeople.services.exceptions.EntitieValidationException;
import com.api.apipeople.services.exceptions.ResourceNotFound;
import com.api.apipeople.services.exceptions.UnauthorizedError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFound e){
        String error = "Resouce was not found.";
        HttpStatus statusCode = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(statusCode, error, e.getMessage());
        return ResponseEntity.status(statusCode).body(standardError);
    }

    @ExceptionHandler(EntitieValidationException.class)
    public ResponseEntity<Object> resourceNotFound(EntitieValidationException e){
        String error = "Entitie validation error";
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(statusCode, error, e.getMessage());
        return ResponseEntity.status(statusCode).body(standardError);
    }

    @ExceptionHandler(UnauthorizedError.class)
    public ResponseEntity<Object> unauthorized(UnauthorizedError e){
        String error = "Not authorized";
        HttpStatus statusCode = HttpStatus.UNAUTHORIZED;
        StandardError standardError = new StandardError(statusCode, error, e.getMessage());
        return ResponseEntity.status(statusCode).body(standardError);
    }

}
