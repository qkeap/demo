package com.q.onboarding.demo.domain.models;

public class Contact {
  private long id;
  private String email;
  private String firstName;
  private String lastName;

  public Contact() {}

  public Contact(long id, String email, String firstName, String lastName) {
    this.id = id;
    this.email = email;

    this.firstName = firstName;
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }
}
