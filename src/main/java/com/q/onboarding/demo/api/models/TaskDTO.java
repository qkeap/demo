package com.q.onboarding.demo.api.models;

public class TaskDTO {
  private long id;
  private String title;
  private boolean completed;
  private ContactDTO contact;

  public TaskDTO(long id, String title, boolean completed, ContactDTO contact) {

    this.id = id;
    this.title = title;
    this.completed = completed;
    this.contact = contact;
  }

  public long getId() {
    return id;
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
