package com.moisha.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.moisha.model.User;

@Repository
public interface UserRepository {
  User selectUserByEmail(
    @Param("email") String email
  );

  User selectUserByUserId(
    @Param("userId") String userId
  );

  User selectUserByUserIdAndPassword(
    @Param("userId") String userId
    , @Param("password") String password
  );
}
