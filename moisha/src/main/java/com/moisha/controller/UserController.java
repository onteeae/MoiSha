package com.moisha.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moisha.model.User;
import com.moisha.model.request.AuthRequest;
import com.moisha.model.response.JwtResponse;
import com.moisha.moisha.security.UserDetail;
import com.moisha.moisha.security.jwt.JwtUtils;
import com.moisha.service.UserService;

@RestController
@RequestMapping("users/")
public class UserController {
  @Autowired
  UserService userService;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @RequestMapping(value = "{userId}", method = RequestMethod.GET)
  public User getUserInfo(
    @PathVariable("userId") String userId
  ) {
    User user = userService.getUser(userId);
    return user;
  }
  @RequestMapping(value="/auth/signIn", method=RequestMethod.POST)
  public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authRequest) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(authRequest.getUserId(), authRequest.getUserPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    UserDetail userDetails = (UserDetail)authentication.getPrincipal();

    return ResponseEntity.ok(new JwtResponse(jwt,
      userDetails.getUsername(),
      userDetails.getEmail()));
  }
}
