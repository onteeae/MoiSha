package com.moisha.moisha.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.moisha.model.User;
import com.moisha.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.selectUserByEmail(email);
    return UserDetail.from(user);
  }
}
