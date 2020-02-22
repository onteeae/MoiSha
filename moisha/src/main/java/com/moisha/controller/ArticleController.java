package com.moisha.controller;

import javax.websocket.server.PathParam;

import com.moisha.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.moisha.service.ArticleService;

import java.util.List;

@RestController
@RequestMapping("articles/")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @RequestMapping(value = "user/{userId}/interest/{interestNo}", method = RequestMethod.GET)
  public List<Article> getArticles(
          @PathVariable("userId") String userId
          , @PathVariable("interestNo") Long interestNo
          , @RequestParam(value = "offset", defaultValue = "0") Integer offset
          , @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {
    List<Article> articles = articleService.getArticlesByInterestAndAuthor(userId, interestNo, offset, pageSize);
    return articles;
  }
}
