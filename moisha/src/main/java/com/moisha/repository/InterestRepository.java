package com.moisha.repository;

import com.moisha.model.Interest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository {
  public List<Interest> selectInterestsAll(

  );
  public List<Interest> selectInterestsByUserId(
          @Param("userId") String userId
  );
}
