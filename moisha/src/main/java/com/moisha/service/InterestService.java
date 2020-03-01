package com.moisha.service;

import com.moisha.model.Interest;
import com.moisha.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InterestService {
  @Autowired
  private InterestRepository interestRepository;

  @Transactional
  public List<Interest> getInterestsAll() {
    List<Interest> interests = interestRepository.selectInterestsAll();
    return interests;
  }

  @Transactional
  public List<Interest> getInterestsByUserId(String userId) {
    List<Interest> interests = interestRepository.selectInterestsByUserId(userId);
    return interests;
  }

}
