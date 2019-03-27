package com.q.onboarding.demo.api.controllers;

import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ModelConverter;
import com.q.onboarding.demo.domain.services.TaskService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
  private TaskService taskService;
  private ModelConverter modelConverter;

  public TaskController(TaskService taskService, ModelConverter modelConverter) {
    this.taskService = taskService;
    this.modelConverter = modelConverter;
  }

  @PostMapping("/task")
  public ResponseEntity<TaskDTO> addTask(
      @RequestHeader(value = "Authorization") String authorization, TaskDTO taskDTO) {
    Task task =
        taskService.addTask(modelConverter.ConvertTaskDTOToDomainModel(taskDTO), authorization);
    return new ResponseEntity<>(
        modelConverter.ConvertTaskDomainModelToDTO(task), HttpStatus.CREATED);
  }

  @RequestMapping("/task/{contactId}")
  public ResponseEntity<List<TaskDTO>> getTasksForContact(
      @RequestHeader(value = "Authorization") String authorization, @PathVariable long contactId) {

    return new ResponseEntity<>(
        taskService.getTasksForContact(contactId, authorization).stream()
            .map(task -> modelConverter.ConvertTaskDomainModelToDTO(task))
            .collect(Collectors.toList()),
        HttpStatus.OK);
  }
}
