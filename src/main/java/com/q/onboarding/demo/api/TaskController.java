package com.q.onboarding.demo.api;

import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ITaskService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
  private ITaskService taskService;

  public TaskController(ITaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/task")
  public Task AddTaskToContact(
      HttpServletRequest request,
      HttpServletResponse response,
      @RequestParam(required = false) Task task) {

    String authorization = request.getHeader("Authorization");
    if (null == authorization
        || authorization.trim().length() <= 0
        || !authorization.contains(" ")) {
      response.setStatus(401);
      return null;
    }
    String token = authorization.split(" ")[1];

    return taskService.AddTask(task, token);
  }

  @RequestMapping("/task/contact/{contactId}")
  public Task[] GetTasksForContact(@PathVariable int contactId) {
    return taskService.GetTasksForContact(contactId);
  }
}
