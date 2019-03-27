package com.q.onboarding.demo.data.services;

import com.q.onboarding.demo.data.models.PagingTaskList;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.TaskService;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfusionsoftTaskService implements TaskService {
  private final String apiUri = "https://api.infusionsoft.com/crm/rest/v1/tasks";

  public Task addTask(Task task, String authorization) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authorization);
    HttpEntity<?> request = new HttpEntity<>(task, headers);
    ResponseEntity<Task> response = restTemplate.postForEntity(apiUri, request, Task.class);
    return response.getBody();
  }

  public List<Task> getTasksForContact(long contactId, String authorization) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authorization);
    HttpEntity<?> request = new HttpEntity<>(headers);
    ResponseEntity<PagingTaskList> response = restTemplate.exchange(
        apiUri + "?contact_id=" + contactId, HttpMethod.GET, request, PagingTaskList.class);
    return Arrays.asList(response.getBody().getTasks());
  }
}