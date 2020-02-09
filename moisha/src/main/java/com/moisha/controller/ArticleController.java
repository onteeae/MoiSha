package com.moisha.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moisha.service.ArticleService;

@Controller
@RequestMapping("articles/")
public class ArticleController {

  @Autowired
  private ArticleService articleService;
  @RequestMapping("user/{userId}/interest/{interestNo}")
  public void getArticles(
    @PathParam("userId") String userId
    , @PathParam("interestNo") Long interestNo
    , @RequestParam("offset") Integer offset
    , @RequestParam("pageSize") Integer pageSize
  ) {
    articleService.getArticlesByInterestAndAuthor(userId, interestNo, offset, pageSize);
  }
}
