package com.q.onboarding.demo;

import com.q.onboarding.demo.models.Task;
import com.q.onboarding.demo.services.ITaskService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
  private ITaskService taskService;

  public DemoController(ITaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/tasks")
  public Task AddTaskToContact(
      @RequestParam(defaultValue = "5") int contactId, @RequestParam(required = false) Task task) {
    return taskService.AddTaskToContact(contactId, task);
  }

  @RequestMapping("/tasks/{contactId}")
  public Task[] GetTasksForContact(@PathVariable int contactId) {
    return taskService.GetTasksForContact(contactId);
  }
}