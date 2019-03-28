package com.q.onboarding.demo.api.models;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TaskDTO {
  @NotBlank private String title;
  private boolean completed;

  @NotNull @Valid
  private ContactDTO contact;

  public TaskDTO() {}

  public TaskDTO(String title, boolean completed, ContactDTO contact) {

    this.title = title;
    this.completed = completed;
    this.contact = contact;
  }

  public String getTitle() {
    return title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public ContactDTO getContact() {
    return contact;
  }
}
