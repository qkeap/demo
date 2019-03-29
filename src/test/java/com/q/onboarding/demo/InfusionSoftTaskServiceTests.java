package com.q.onboarding.demo;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

import com.q.onboarding.demo.data.models.PagingTaskList;
import com.q.onboarding.demo.data.services.InfusionsoftTaskService;
import com.q.onboarding.demo.domain.models.Task;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class InfusionSoftTaskServiceTests {

  private InfusionsoftTaskService service;
  @Mock private RestTemplate restTemplate;

  @Before
  public void setup() {
    initMocks(this);
    service = new InfusionsoftTaskService(restTemplate);
  }

  // This is a contrived test to ensure the task controller goes through the motions
  @Test
  public void addTaskSucceeds() {
    Task taskTemplate = new Task("test", false, null);
    Mockito.doReturn(new ResponseEntity<>(taskTemplate, HttpStatus.OK))
        .when(restTemplate)
        .exchange(anyString(), eq(HttpMethod.POST), anyObject(), eq(Task.class));
    Task task = service.addTask(taskTemplate, "");
    Assert.assertEquals(task, taskTemplate);
  }

  @Test
  public void getTasksForContactSucceeds() {
    PagingTaskList taskList = new PagingTaskList(Arrays.asList(new Task("test", false, null)));
    Mockito.doReturn(new ResponseEntity<>(taskList, HttpStatus.OK))
        .when(restTemplate)
        .exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(PagingTaskList.class));
    List<Task> tasks = service.getTasksForContact(0, "");
    Assert.assertEquals(tasks, taskList.getTasks());
    Assert.assertEquals(tasks.size(), taskList.getTasks().size());
  }
}
