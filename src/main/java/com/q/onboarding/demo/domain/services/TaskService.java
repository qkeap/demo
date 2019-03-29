package com.q.onboarding.demo.domain.services;

import com.q.onboarding.demo.data.InfusionsoftServiceException;
import com.q.onboarding.demo.domain.models.Task;
import java.util.List;

public interface TaskService {
  Task addTask(Task task, String authorization) throws InfusionsoftServiceException;

  List<Task> getTasksForContact(long contactId, String authorization)
      throws InfusionsoftServiceException;
}
