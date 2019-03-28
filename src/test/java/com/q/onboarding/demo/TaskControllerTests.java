package com.q.onboarding.demo;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.q.onboarding.demo.api.controllers.TaskController;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ModelConverter;
import com.q.onboarding.demo.domain.services.TaskService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class TaskControllerTests {

  @Mock private TaskService service;

  @Mock private ModelConverter modelConverter;

  private TaskController controller;
  private Task taskTemplate;
  private TaskDTO taskDTOTemplate;

  @Before
  public void setup() {
    initMocks(this);

    this.taskDTOTemplate = Mockito.mock(TaskDTO.class);
    this.taskTemplate = Mockito.mock(Task.class);

    controller = new TaskController(service, modelConverter);
  }

  @Test
  public void contextLoads() {
    Assert.assertNotEquals(controller, null);
  }

  // This is a contrived test to ensure the task controller goes through the motions
  @Test
  public void addTaskSucceeds() {
    when(service.addTask(any(Task.class), anyString())).thenReturn(taskTemplate);
    when(modelConverter.convertTaskDTOToDomainModel(any(TaskDTO.class))).thenReturn(taskTemplate);
    when(modelConverter.convertTaskDomainModelToDTO(any(Task.class))).thenReturn(taskDTOTemplate);
    ResponseEntity<TaskDTO> response = controller.addTask("", taskDTOTemplate);
    Assert.assertEquals(response.getBody(), taskDTOTemplate);
  }

  @Test
  public void getTasksForContactSucceeds(){
    when(modelConverter.convertTaskDTOToDomainModel(any(TaskDTO.class))).thenReturn(taskTemplate);
    when(modelConverter.convertTaskDomainModelToDTO(any(Task.class))).thenReturn(taskDTOTemplate);
    when(service.getTasksForContact(anyLong(), anyString())).thenReturn(Arrays.asList(taskTemplate));
    ResponseEntity<List<TaskDTO>> response = controller.getTasksForContact("", 0);
    Assert.assertEquals(response.getBody().get(0), taskDTOTemplate);
  }
}