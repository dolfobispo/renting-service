package com.movieservice.advices;

import java.io.Serializable;
import java.time.Instant;
import java.util.Map;

public class InvalidFieldError implements Serializable {

    private Instant timeStamp;
    private Integer status;
    private String error;
    private Map<String,String>  invalid_fields;
    private String path;

    public Map<String, String> getInvalid_fields() {
        return invalid_fields;
    }

    public void setInvalid_fields(Map<String, String> invalid_fields) {
        this.invalid_fields = invalid_fields;
    }

    public InvalidFieldError(){ };
    public InvalidFieldError(Instant timeStamp, Integer status, String error, Map<String,String>  invalidFields, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.error = error;
        this.invalid_fields = invalidFields;
        this.path = path;
    }


    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
