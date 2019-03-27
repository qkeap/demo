package com.q.onboarding.demo.domain.models;

public class Task {
  private long id;
  private String title;
  private boolean completed;
  private Contact contact;

  public Task() {}

  public Task(long id, String title, boolean completed, Contact contact) {

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

  public Contact getContact() {
    return contact;
  }
}
