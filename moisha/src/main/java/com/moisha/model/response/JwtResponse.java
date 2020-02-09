package com.moisha.model.response;

import java.util.List;

import lombok.Data;

@Data
public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private String username;
  private String email;
  private List<String> roles;

  public JwtResponse(String accessToken, String username, String email) {
    this.token = accessToken;
    this.username = username;
    this.email = email;
  }
}
