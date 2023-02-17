package com.api.apipeople.controllers.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpResponse {

    public HttpResponse(){}

    public <T> ResponseEntity<Object> badRequest(T data){
        return new ResponseEntity<>(new ResponseObject(data, HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
    }

    public <T> ResponseEntity<Object> created(T data){
        return new ResponseEntity<>(new ResponseObject(data, HttpStatus.CREATED),HttpStatus.CREATED);
    }

    public <T> ResponseEntity<Object> ok(T data){
        return new ResponseEntity<>(new ResponseObject(data, HttpStatus.OK),HttpStatus.OK);
    }

}
