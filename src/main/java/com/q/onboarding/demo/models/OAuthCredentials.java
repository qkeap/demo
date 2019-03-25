package com.q.onboarding.demo.models;

import java.io.Serializable;

public class OAuthCredentials implements Serializable {
  private String accessToken;
  private String refreshToken;
  private String clientId;
  private String clientSecret;
  private String code;

  public OAuthCredentials() {}
  public OAuthCredentials(String clientId, String clientSecret, String code) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.code = code;
  }

  public String getClientId() {
    return clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public String getCode() {
    return code;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
