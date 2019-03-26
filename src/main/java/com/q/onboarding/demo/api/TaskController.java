package com.q.onboarding.demo.api;

import com.q.onboarding.demo.domain.services.TaskService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
  private TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/task")
  public ResponseEntity<?> addTask(
      @RequestHeader(value = "Authorization") String authorization,
      @RequestBody Map<String, String> parameters) {
    ResponseEntity<?> taskResponse = taskService.addTask(parameters, authorization);
    return taskResponse;
  }

  @RequestMapping("/task/contact/{contactId}")
  public ResponseEntity<?> getTasksForContact(
      @RequestHeader(value = "Authorization") String authorization, @PathVariable int contactId) {

    return taskService.getTasksForContact(contactId, authorization);
  }
}
