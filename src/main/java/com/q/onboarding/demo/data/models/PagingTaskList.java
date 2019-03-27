package com.q.onboarding.demo.data.models;

import com.q.onboarding.demo.domain.models.Task;
import java.util.List;

public class PagingTaskList {
  private List<Task> tasks;

  public PagingTaskList() {
  }

  public List<Task> getTasks() {
    return tasks;
  }
}
