package com.q.onboarding.demo.models;

public class Task {
  private int Id;
  private String Name;
  private boolean Completed;


  public Task(int id, String name, boolean completed){
    Id = id;
    Name = name;
    Completed = completed;
  }

  public int getId() {
    return Id;
  }

  public String getName() {
    return Name;
  }

  public boolean isCompleted() {
    return Completed;
  }
}
