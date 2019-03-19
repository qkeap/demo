package com.q.onboarding.demo.models;

public class Contact {

  private int Id;
  private String Name;

  public Contact(int id, String name){
    this.Id = id;
    this.Name = name;
  }

  public int getId() {
    return Id;
  }

  public String getName() {
    return Name;
  }
}