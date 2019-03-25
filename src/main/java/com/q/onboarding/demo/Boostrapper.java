package com.q.onboarding.demo;

import com.q.onboarding.demo.services.AuthService;
import com.q.onboarding.demo.services.IAuthService;
import com.q.onboarding.demo.services.ITaskService;
import com.q.onboarding.demo.services.TaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Boostrapper {
  @Bean
  public ITaskService taskService() {
    return new TaskService();
  }
  @Bean
  public IAuthService authService() {
    return new AuthService();
  }
}