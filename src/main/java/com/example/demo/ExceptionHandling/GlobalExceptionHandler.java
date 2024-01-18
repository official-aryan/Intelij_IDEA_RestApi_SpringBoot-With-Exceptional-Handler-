package com.example.demo.ExceptionHandling;

import com.example.demo.Payload.errorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<errorDetails> handlerMethod(ResourceNotFoundException e, WebRequest webRequest){

        errorDetails e1 = new errorDetails(e.getMessage(),new Date(),webRequest.getDescription(true));

        return new ResponseEntity<>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
