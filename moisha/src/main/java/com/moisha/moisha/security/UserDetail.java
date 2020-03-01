package com.moisha.moisha.security;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.moisha.model.User;
import lombok.Data;

@Data
public class UserDetail implements UserDetails {
  private String userId;
  private String email;
  @JsonIgnore
  private String userPassword;


  private Collection<? extends GrantedAuthority> authorities;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.userPassword;
  }

  @Override
  public String getUsername() {
    return this.userId;
  }

  public String getUserEmail() { return this.email;}

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object user) {
    if (this == user)
      return true;
    if (user == null || getClass() != user.getClass())
      return false;
    return Objects.equals(this.userId, ((UserDetail)user).userId);
  }

  public static UserDetail from(User user) {
    UserDetail userDetail = new UserDetail();
    userDetail.setUserId(user.getUserId());
    userDetail.setEmail(user.getEmail());
    userDetail.setUserPassword(user.getUserPassword());
    return userDetail;
  }

}
