package com.moisha.moisha.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.moisha.model.MoishaAuthentication;
import com.moisha.model.User;
import com.moisha.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthProvider implements AuthenticationProvider {
  @Autowired
  UserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String userId = authentication.getName();
    String userPw = authentication.getCredentials().toString();
    return authenticate(userId, userPw);
  }

  private Authentication authenticate(String userId, String password) throws AuthenticationException {
    User user = userService.getUserAuth(userId, password);
    if ( user == null || !user.getUserPassword().equals(password)) {
      log.warn(String.format("잘못된 로그인 요청. usedId: [%s]"), userId);
      return null;
    }
    List authList = new ArrayList<>();
    /**
     * Role 처리 필요, 일단 임의로 USER Role을 부여한다.
     **/
    authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    return new MoishaAuthentication(userId, password, authList, user);
  }

  @Override
  public boolean supports(Class authentication) {
    return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
  }
}
