package com.q.onboarding.demo.services;

import com.q.onboarding.demo.models.Task;

public class TaskService implements ITaskService {

  @Override
  public Task AddTaskToContact(int contactId, Task task) {
    return new Task(1000, "Test Task", false);
  }

  public Task[] GetTasksForContact(int contactId){
    return new Task[] {
        new Task(1000, "Test Task #1", false),
        new Task(1001, "Test Task #2", false),
        new Task(1002, "Test Task #3", false),
        new Task(1003, "Test Task #4", false)
    };
  }
}