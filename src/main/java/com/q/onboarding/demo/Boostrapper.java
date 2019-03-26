package com.q.onboarding.demo;

import com.q.onboarding.demo.domain.services.ITaskService;
import com.q.onboarding.demo.domain.services.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Boostrapper {
  @Bean
  public ITaskService taskService() {
    return new TaskService();
  }
}