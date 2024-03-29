package com.q.onboarding.demo.api.controllers;

import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.data.InfusionsoftServiceException;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ModelConverter;
import com.q.onboarding.demo.domain.services.TaskService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
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
      @RequestHeader(value = "Authorization") String authorization,
      @Valid @RequestBody TaskDTO taskDTO)
      throws InfusionsoftServiceException {
    Task task =
        taskService.addTask(modelConverter.convertTaskDTOToDomainModel(taskDTO), authorization);
    return new ResponseEntity<>(
        modelConverter.convertTaskDomainModelToDTO(task), HttpStatus.CREATED);
  }

  @GetMapping("/task")
  public ResponseEntity<List<TaskDTO>> getTasksForContact(
      @RequestHeader(value = "Authorization") String authorization, @RequestParam long contactId)
      throws InfusionsoftServiceException {

    return new ResponseEntity<>(
        taskService.getTasksForContact(contactId, authorization).stream()
            .map(task -> modelConverter.convertTaskDomainModelToDTO(task))
            .collect(Collectors.toList()),
        HttpStatus.OK);
  }
}
