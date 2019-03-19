package com.q.onboarding.demo.services;

import com.q.onboarding.demo.models.Task;

public interface ITaskService {
  Task AddTaskToContact(int contactId, Task task);
  Task[] GetTasksForContact(int contactId);
}