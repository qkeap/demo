package com.q.onboarding.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.q.onboarding.demo.api.controllers.TaskController;
import com.q.onboarding.demo.api.models.TaskDTO;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.ModelConverter;
import com.q.onboarding.demo.domain.services.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTests {

  @Mock private TaskService service;

  @Mock private ModelConverter modelConverter;

  private TaskController controller;

  @Before
  public void setup() {
    initMocks(this);

    controller = new TaskController(service, modelConverter);
  }

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

  // This is a contrived test to ensure the task controller goes through the motion on a success case
  @Test
  public void addTaskSucceeds() {
    TaskDTO testDto = Mockito.mock(TaskDTO.class);
    Task testTask = Mockito.mock(Task.class);
    when(service.addTask(any(Task.class), anyString())).thenReturn(testTask);
    when(modelConverter.convertTaskDTOToDomainModel(any(TaskDTO.class))).thenReturn(testTask);
    when(modelConverter.convertTaskDomainModelToDTO(any(Task.class))).thenReturn(testDto);
    ResponseEntity<TaskDTO> response = controller.addTask("", testDto);
    assertThat(response.getBody()).isEqualTo(testDto);
  }
}
