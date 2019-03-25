package com.q.onboarding.demo;

import com.q.onboarding.demo.models.OAuthCredentials;
import com.q.onboarding.demo.services.IAuthService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  private IAuthService authService;
  private Environment environment;

  public AuthController(IAuthService authService, Environment environment) {
    this.authService = authService;
    this.environment = environment;
  }

  @RequestMapping("/authorize")
  public void Authorize(HttpServletResponse response) {
    String authorizationUri = environment.getProperty("AUTH_URI");
    String redirectUri = environment.getProperty("AUTH_REDIRECT_URI");
    String clientId = environment.getProperty("AUTH_CLIENT_ID");
    response.setHeader(
        "Location",
        authorizationUri
            + "/redirect_uri="
            + redirectUri
            + "&response_type=code&client_id="
            + clientId);
    response.setStatus(302);
  }

  @PostMapping("/oauth_callback")
  public String OAuthCallback(@RequestParam() String code) throws IOException {
    String clientId = environment.getProperty("AUTH_CLIENT_ID");
    String clientSecret = environment.getProperty("AUTH_CLIENT_SECRET");
    OAuthCredentials credentials = authService.RequestAccessToken(clientId, clientSecret, code);
    Files.write(
        Paths.get("~/.is-credentials"),
        credentials.getAccessToken().getBytes(StandardCharsets.UTF_8));
    return credentials.getAccessToken();
  }
}