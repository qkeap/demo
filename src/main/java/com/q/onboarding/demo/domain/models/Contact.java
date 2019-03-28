package com.q.onboarding.demo.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
  private long id;
  private String email;
  @JsonProperty(value = "first_name")
  private String firstName;
  @JsonProperty(value = "last_name")
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
