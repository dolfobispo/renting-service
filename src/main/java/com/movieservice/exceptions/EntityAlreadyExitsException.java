package com.movieservice.exceptions;

public class EntityAlreadyExitsException extends RuntimeException {
    public EntityAlreadyExitsException(String msg){
        super(msg);
    }
}
