package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.domain.models.Task;
import java.util.List;

public interface TaskService {
  Task addTask(Task task, String authorization);
  List<Task> getTasksForContact(long contactId, String authorization);
}