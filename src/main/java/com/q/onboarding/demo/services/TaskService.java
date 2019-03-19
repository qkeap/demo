package com.q.onboarding.demo.services;

import com.q.onboarding.demo.models.Task;

public class TaskService implements ITaskService {

  @Override
  public Task AddTaskToContact(int contactId, Task task) {
    return new Task(1000, "Test Task");
  }
}
