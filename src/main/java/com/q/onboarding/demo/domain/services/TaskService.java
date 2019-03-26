package com.q.onboarding.demo.domain.services;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface TaskService {
  ResponseEntity<?> addTask(Map<String, String> task, String authorization);
  ResponseEntity<?> getTasksForContact(int contactId, String authorization);
}