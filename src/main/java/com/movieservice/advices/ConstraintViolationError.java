package com.movieservice.advices;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ConstraintViolationError extends Throwable implements Serializable  {
    private HttpStatus status;
    private String error;
    private String field;
    public ConstraintViolationError(HttpStatus status, String error , String field){
        this.status = status;
        this.error = error;
        this.field = field;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
