package com.moisha.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.moisha.model.User;

@Repository
public interface UserRepository {
  public User selectUserByUserId(
    @Param("userId") String userId
  );
}
