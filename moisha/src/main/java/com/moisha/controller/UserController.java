package com.moisha.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.moisha.service.UserService;
import com.sun.deploy.net.HttpResponse;

@Controller
@RequestMapping("users/")
public class UserController {
  @Autowired
  UserService userService;

  @RequestMapping(value = "{userId}", method = RequestMethod.GET)
  public HttpResponse getUserInfo(
    @PathVariable("userId") String userId
  ) {
    return userService.getUserInfo(userId);
  }

  @RequestMapping("signin")
  public HttpResponse signIn(@RequestParam("userId") String userId
    , @RequestParam("password") String password
  ) {
  }

  @RequestMapping("signup")
  public HttpResponse signUp() {

  }

  @RequestMapping("singout")
  public HttpResponse signOut() {

  }
}
