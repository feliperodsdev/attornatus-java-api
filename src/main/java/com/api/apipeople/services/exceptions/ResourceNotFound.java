package com.api.apipeople.services.exceptions;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound(Object id){
        super("Resource not found, id: " + id);
    }

}
