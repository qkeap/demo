package com.q.onboarding.demo.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

//  @ExceptionHandler(value = {MethodArgumentNotValidException.class})
//  protected ResponseEntity<Object> handleValidationError(RuntimeException ex, WebRequest request) {
//    String bodyOfResponse =
//        "The request was not properly formed and cannot be completed, fix these errors and try again.\n"
//            + ex.toString();
//    return handleExceptionInternal(
//        ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//  }
}