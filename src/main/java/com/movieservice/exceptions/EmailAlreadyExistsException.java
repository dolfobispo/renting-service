package com.movieservice.exceptions;

public class EmailAlreadyExistsException extends EntityAlreadyExitsException{
    public EmailAlreadyExistsException(){
        super("Email already exists");
    }
}
