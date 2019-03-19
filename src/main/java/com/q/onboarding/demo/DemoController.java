package com.q.onboarding.demo;

import com.q.onboarding.demo.models.Task;
import com.q.onboarding.demo.services.ITaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private ITaskService _taskService;

  public DemoController(ITaskService taskService){
    _taskService = taskService;
  }

  @PostMapping("/tasks")
  public Task AddTaskToContact(
      @RequestParam(defaultValue = "5") int contactId,
      @RequestParam(required = false) Task task) {
    return _taskService.AddTaskToContact(contactId, task);
  }
}
