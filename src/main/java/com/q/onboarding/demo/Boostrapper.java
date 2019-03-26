package com.q.onboarding.demo;

import com.q.onboarding.demo.domain.services.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Boostrapper {
  @Bean
  public TaskService taskService() {
    return new com.q.onboarding.demo.data.TaskService();
  }
}