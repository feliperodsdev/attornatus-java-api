package com.api.apipeople.controllers.exceptions;

import org.springframework.http.HttpStatus;

public class StandardError {

    private HttpStatus statusCode;
    private String error;
    private String message;

    public StandardError(HttpStatus statusCode, String error, String message) {
        super();
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
