package com.q.onboarding.demo.data;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TaskService implements com.q.onboarding.demo.domain.services.TaskService {

  private final String apiUri = "https://api.infusionsoft.com/crm/rest/v1/tasks";

  public ResponseEntity<?> addTask(Map<String, String> task, String authorization) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authorization);
    HttpEntity<?> request = new HttpEntity<>(task, headers);
    return restTemplate.postForEntity(apiUri, request, Object.class);
  }

  public ResponseEntity<?> getTasksForContact(int contactId, String authorization) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authorization);
    HttpEntity<?> request = new HttpEntity<>(headers);
    return restTemplate.exchange(
        apiUri + "?contact_id=" + contactId, HttpMethod.GET, request, Object.class);
  }
}