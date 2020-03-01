package com.moisha.controller;

import com.moisha.model.Interest;
import com.moisha.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interests")
public class InterestController {
    @Autowired
    private InterestService interestService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Interest> getInterests() {
        List<Interest> interests = interestService.getInterestsAll();
        return interests;
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public List<Interest> getInterests(
            @PathVariable("userId") String userId
    ) {
        List<Interest> interests = interestService.getInterestsByUserId(userId);
        return interests;
    }
}
