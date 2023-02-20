package com.api.apipeople.services.exceptions;

public class UnauthorizedError extends RuntimeException {

    public UnauthorizedError(String msg){
        super(msg);
    }

}
