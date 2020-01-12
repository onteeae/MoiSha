package com.moisha.controller;

import javax.websocket.server.PathParam;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moisha.model.User;
import com.moisha.service.UserService;

@RestController
@RequestMapping("users/")
public class UserController {
  @Autowired
  UserService userService;

  @RequestMapping(value = "{userId}", method = RequestMethod.GET)
  public User getUserInfo(
    @PathVariable("userId") String userId
  ) {
    User user = userService.getUserInfo(userId);
    return user;
  }
}
