package com.q.onboarding.demo.services;

import com.q.onboarding.demo.models.OAuthCredentials;

public interface IAuthService {
  OAuthCredentials RequestAccessToken(String clientId, String clientSecret, String code);
}
