package com.q.onboarding.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentVars {
  @Value("${AUTH_REDIRECT_URI:#{null}}")
  private String authRedirectUri;

  @Value("${AUTH_URI:#{null}}")
  private String authUri;

  @Value("${AUTH_CLIENT_SECRET:#{null}}")
  private String authClientSecret;

  @Value("${AUTH_CLIENT_ID:#{null}}")
  private String authClientId;

  public String getAuthRedirectUri() {
    return authRedirectUri;
  }

  public String getAuthUri() {
    return authUri;
  }

  public String getAuthClientSecret() {
    return authClientSecret;
  }

  public String getAuthClientId() {
    return authClientId;
  }
}
