package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.domain.models.Task;

public class TaskService implements ITaskService {

  public Task AddTask(Task task, String token) {
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