package com.example.driverservice.exception.advice;

import com.example.driverservice.exception.DriverDoesnAssignOrderException;
import com.example.driverservice.exception.response.ExeptionResponse;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class OrderAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException() {
        return new ResponseEntity<>("driver not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> handleSQLIntegrityConstraintViolationException() {
        return new ResponseEntity<>("driver exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> FeignException() {
        return new ResponseEntity<>("order not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DriverDoesnAssignOrderException.class)
    public ResponseEntity<ExeptionResponse> DriverDoesnAssignOrderException(DriverDoesnAssignOrderException e) {
        ExeptionResponse exeptionResponse = new ExeptionResponse(e.getMessage());
        return new ResponseEntity<>(exeptionResponse, HttpStatus.CONFLICT);
    }
}