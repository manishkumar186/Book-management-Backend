package com.example.BookManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookNotFound.class)
    public ResponseEntity<Object> handleBookNotFound(BookNotFound ex, WebRequest request){

        return new ResponseEntity<Object>(new ApiError(ex.getMessage()),HttpStatus.NOT_FOUND);
    }

}
