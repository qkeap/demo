package com.q.onboarding.demo.data.models;

import com.q.onboarding.demo.domain.models.Task;

public class PagingTaskList {
  private Task[] tasks;

  public PagingTaskList() {
  }

  public Task[] getTasks() {
    return tasks;
  }
}
