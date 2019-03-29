package com.q.onboarding.demo.api;

import com.q.onboarding.demo.data.InfusionsoftServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

  @ExceptionHandler(value = {InfusionsoftServiceException.class})
  protected ResponseEntity<Error> handleServiceError(RuntimeException ex, WebRequest request) {
    return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
