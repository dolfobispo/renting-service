package com.movieservice.advices;


import com.movieservice.exceptions.DatabaseException;
import com.movieservice.exceptions.EntityAlreadyExitsException;
import com.movieservice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest httpServletRequest){
        String error = "Resource not found";
        HttpStatus  status = HttpStatus.NOT_FOUND;
        StandError standError = new StandError(Instant.now(),status.value(),error, ex.getMessage(),httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standError);

    }
    @ExceptionHandler(EntityAlreadyExitsException.class)
    public ResponseEntity<StandError> entityAlreadyExists(EntityAlreadyExitsException ex, HttpServletRequest httpServletRequest){
        String error = "Entity Already Exists";
        HttpStatus  status = HttpStatus.CONFLICT;
        StandError standError = new StandError(Instant.now(),status.value(),error, ex.getMessage(),httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standError);

    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandError> database(DatabaseException ex, HttpServletRequest httpServletRequest){
        String error = "database error";
        HttpStatus  status = HttpStatus.BAD_REQUEST;
        StandError standError = new StandError(Instant.now(),status.value(),error, ex.getMessage(),httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standError);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<InvalidFieldError> handleValidationException(
            MethodArgumentNotValidException ex,HttpServletRequest httpServletRequest) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        String error = "invalid fields";
        HttpStatus  status = HttpStatus.BAD_REQUEST;
        InvalidFieldError invalidFieldError = new InvalidFieldError(Instant.now(),status.value(),error,errors,httpServletRequest.getRequestURI());
        return ResponseEntity.status(status).body(invalidFieldError);
    }
}
