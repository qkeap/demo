package com.q.onboarding.demo.api.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ContactDTO {
  @Min(1)
  @Max(Long.MAX_VALUE)
  private long id;

  private String email;
  private String firstName;
  private String lastName;

  public ContactDTO() {}

  public ContactDTO(long id, String email, String firstName, String lastName) {
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
