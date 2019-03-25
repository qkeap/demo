package com.q.onboarding.demo;

import com.q.onboarding.demo.models.OAuthCredentials;
import com.q.onboarding.demo.services.IAuthService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  private IAuthService authService;
  private EnvironmentVars vars;

  public AuthController(IAuthService authService, EnvironmentVars vars) {
    this.authService = authService;
    this.vars = vars;
  }

  @RequestMapping("/authorize")
  public void Authorize(HttpServletResponse response) {
    String authorizationUri = vars.getAuthUri();
    String redirectUri = vars.getAuthRedirectUri();
    String clientId = vars.getAuthClientId();
    authorizationUri =
        authorizationUri
            + "/redirect_uri="
            + redirectUri
            + "&response_type=code&client_id="
            + clientId;
    System.out.println("uri: " + authorizationUri);
    response.setHeader("Location", authorizationUri);
    response.setStatus(302);
  }

  @PostMapping("/oauth_callback")
  public String OAuthCallback(@RequestParam() String code) throws IOException {
    String clientId = vars.getAuthClientId();
    String clientSecret = vars.getAuthClientSecret();
    OAuthCredentials credentials = authService.RequestAccessToken(clientId, clientSecret, code);
    Files.write(
        Paths.get("~/.is-credentials"),
        credentials.getAccessToken().getBytes(StandardCharsets.UTF_8));
    return credentials.getAccessToken();
  }
}
