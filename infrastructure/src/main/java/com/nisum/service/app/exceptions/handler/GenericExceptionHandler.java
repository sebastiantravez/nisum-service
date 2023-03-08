package com.nisum.service.app.exceptions.handler;

import com.nisum.service.app.exceptions.ExceptionResponse;
import com.nisum.service.app.exceptions.GenericException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionResponse> customExceptionHandler(GenericException exception) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .mensaje(exception.getMessage()).build();
        ResponseEntity<ExceptionResponse> response = new ResponseEntity<>(exceptionResponse, exception.getStatus());
        return response;
    }

}
