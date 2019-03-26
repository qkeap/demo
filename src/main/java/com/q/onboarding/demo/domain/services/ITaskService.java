package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.domain.models.Task;

public interface ITaskService {
  Task AddTask(Task task, String token);
  Task[] GetTasksForContact(int contactId);
}