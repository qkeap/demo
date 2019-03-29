package com.q.onboarding.demo;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

import com.q.onboarding.demo.data.InfusionsoftServiceException;
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
import org.springframework.web.server.ResponseStatusException;

public class InfusionSoftTaskServiceTests {

  private InfusionsoftTaskService service;
  @Mock private RestTemplate restTemplate;

  @Before
  public void setup() {
    initMocks(this);
    service = new InfusionsoftTaskService(restTemplate);
  }

  @Test
  public void addTaskSucceedsOnGoodRequest() throws InfusionsoftServiceException {
    Task taskTemplate = new Task("test", false, null);
    Mockito.doReturn(new ResponseEntity<>(taskTemplate, HttpStatus.CREATED))
        .when(restTemplate)
        .exchange(anyString(), eq(HttpMethod.POST), anyObject(), eq(Task.class));
    Task task = service.addTask(taskTemplate, "");
    Assert.assertEquals(task, taskTemplate);
  }

  @Test(expected = InfusionsoftServiceException.class)
  public void addTaskFailsOnBadRequest() throws InfusionsoftServiceException {
    Task taskTemplate = new Task("test", false, null);
    Mockito.doReturn(new ResponseEntity<>(taskTemplate, HttpStatus.BAD_REQUEST))
        .when(restTemplate)
        .exchange(anyString(), eq(HttpMethod.POST), anyObject(), eq(Task.class));
    service.addTask(taskTemplate, "");
  }

  @Test
  public void getTasksForContactSucceedsOnGoodRequest() throws InfusionsoftServiceException {
    PagingTaskList taskList = new PagingTaskList(Arrays.asList(new Task("test", false, null)));
    Mockito.doReturn(new ResponseEntity<>(taskList, HttpStatus.OK))
        .when(restTemplate)
        .exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(PagingTaskList.class));
    List<Task> tasks = service.getTasksForContact(0, "");
    Assert.assertEquals(tasks, taskList.getTasks());
    Assert.assertEquals(tasks.size(), taskList.getTasks().size());
  }

  @Test(expected = InfusionsoftServiceException.class)
  public void getTasksForContactFailsOnBadRequest() throws InfusionsoftServiceException {
    PagingTaskList taskList = new PagingTaskList(Arrays.asList(new Task("test", false, null)));
    Mockito.doReturn(new ResponseEntity<>(taskList, HttpStatus.BAD_REQUEST))
        .when(restTemplate)
        .exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(PagingTaskList.class));
    service.getTasksForContact(0, "");
  }
}
