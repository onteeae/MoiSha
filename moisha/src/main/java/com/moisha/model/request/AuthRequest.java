package com.moisha.model.request;

import lombok.Data;

@Data
public class AuthRequest {
  String userId;
  String userPassword;
}
