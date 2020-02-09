package com.moisha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.moisha.model.User;
import com.moisha.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public User getUser(String userId) {
    return userRepository.selectUserByUserId(userId);
  }

  public User getUserAuth(String userId, String password) {
    return userRepository.selectUserByUserIdAndPassword(userId, password);
  }
}
