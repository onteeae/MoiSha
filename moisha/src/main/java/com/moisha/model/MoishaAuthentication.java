package com.moisha.model;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class MoishaAuthentication extends UsernamePasswordAuthenticationToken {
  User user;
  public MoishaAuthentication(String userId, String password, List authList, User user) {
    super(userId, password, authList);
    this.user = user;
  }
}
