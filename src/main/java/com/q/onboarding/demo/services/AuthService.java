package com.q.onboarding.demo.services;

import com.q.onboarding.demo.models.OAuthCredentials;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class AuthService implements IAuthService {
  @Override
  public OAuthCredentials RequestAccessToken(String clientId, String clientSecret, String code){
    // TODO: Reach out to token endpoint - "Requesting an access token requires you to POST to https://api.infusionsoft.com/token"
    RestTemplate restTemplate = new RestTemplate();
    String apiEndpoint = "https://api.infusionsoft.com/token";
    HttpEntity<OAuthCredentials> request = new HttpEntity<>(new OAuthCredentials(clientId, clientSecret, code));
    OAuthCredentials credentials = restTemplate.postForObject(apiEndpoint, request, OAuthCredentials.class);
    return credentials;
  }
}