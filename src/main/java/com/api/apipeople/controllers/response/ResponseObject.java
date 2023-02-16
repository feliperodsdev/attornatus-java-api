package com.api.apipeople.controllers.response;

import org.springframework.http.HttpStatus;

public class ResponseObject <T> {
    private T data;
    private HttpStatus statusCode;

    public ResponseObject(T data, HttpStatus statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
}
