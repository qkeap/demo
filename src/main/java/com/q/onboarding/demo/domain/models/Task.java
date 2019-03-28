package com.q.onboarding.demo.domain.models;


public class Task {
  private String title;
  private boolean completed;
  private Contact contact;

  public Task() {}

  public Task(String title, boolean completed, Contact contact) {

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

  public Contact getContact() {
    return contact;
  }
}
