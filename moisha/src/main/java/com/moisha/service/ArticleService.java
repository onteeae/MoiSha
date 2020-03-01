package com.moisha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moisha.model.Article;
import com.moisha.repository.ArticleRepository;

@Service
public class ArticleService {
  @Autowired
  private ArticleRepository articleRepository;

  @Transactional
  public List<Article> getArticlesByInterest(Long interestNo, Integer offset, Integer pageSize) {
    List<Article> articles = articleRepository.selectArticlesByInterestNo(interestNo, offset, pageSize);
    return articles;
  }

}
