package com.q.onboarding.demo.data;

public class InfusionsoftServiceException extends Exception {
  private String message;

  public InfusionsoftServiceException(String message) {
    this.message = message;
  }

  public InfusionsoftServiceException(String message, Throwable innerException) {
    this.message = message;
    this.initCause(innerException);
  }

  @Override
  public String getMessage() {
    return message;
  }
}
