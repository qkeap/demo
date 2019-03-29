package com.q.onboarding.demo;

import static org.mockito.MockitoAnnotations.initMocks;

import com.q.onboarding.demo.api.models.ContactDTO;
import com.q.onboarding.demo.api.models.TaskDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class TaskControllerIntegrationTests {
  @LocalServerPort
  private String port;

  @Value("${API_ACCESS_TOKEN:null}")
  private String accessToken;

  private TaskDTO taskDTOTemplate;

  @Before
  public void setup() {
    initMocks(this);

    ContactDTO contact = new ContactDTO(88, null, null, null);
    this.taskDTOTemplate = new TaskDTO("Integration Test", false, contact);
  }

  @Test
  public void addTaskIntegrationSucceeds() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Bearer " + accessToken);
    HttpEntity<?> httpEntity = new HttpEntity<>(taskDTOTemplate, headers);
    ResponseEntity<TaskDTO> task =
        restTemplate.exchange(
            "http://localhost:" + port + "/task", HttpMethod.POST, httpEntity, TaskDTO.class);
    Assert.assertEquals(task.getStatusCode(), HttpStatus.CREATED);
    Assert.assertEquals(task.getBody().getTitle(), taskDTOTemplate.getTitle());
  }
}
