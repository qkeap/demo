package com.q.onboarding.demo.data.services;

import com.q.onboarding.demo.data.InfusionsoftServiceException;
import com.q.onboarding.demo.data.models.PagingTaskList;
import com.q.onboarding.demo.domain.models.Task;
import com.q.onboarding.demo.domain.services.TaskService;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class InfusionsoftTaskService implements TaskService {
  private static final String API_URI = "https://api.infusionsoft.com/crm/rest/v1/tasks";
  private RestTemplate restTemplate;

  public InfusionsoftTaskService() {
    this.restTemplate = new RestTemplate();
  }

  public InfusionsoftTaskService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Task addTask(Task task, String authorization) throws InfusionsoftServiceException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authorization);
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Task> request = new HttpEntity<>(task, headers);
    try {
      ResponseEntity<Task> response =
          restTemplate.exchange(API_URI, HttpMethod.POST, request, Task.class);
      if (response.getStatusCode() != HttpStatus.CREATED) {
        throw new InfusionsoftServiceException(
            "The data could not be saved\n" + response.toString());
      }
      return response.getBody();
    } catch (Exception ex) {
      throw new InfusionsoftServiceException("An error occurred processing the request", ex);
    }
  }

  public List<Task> getTasksForContact(long contactId, String authorization)
      throws InfusionsoftServiceException {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", authorization);
    HttpEntity<?> request = new HttpEntity<>(headers);
    try {
      ResponseEntity<PagingTaskList> response =
          restTemplate.exchange(
              API_URI + "?completed=false&contact_id=" + contactId,
              HttpMethod.GET,
              request,
              PagingTaskList.class);
      if (response.getStatusCode() != HttpStatus.OK) {
        throw new InfusionsoftServiceException(
            "The data could not be retrieved\n" + response.toString());
      }
      return response.getBody().getTasks();
    } catch (Exception ex) {
      throw new InfusionsoftServiceException("An error occurred processing the request", ex);
    }
  }
}
