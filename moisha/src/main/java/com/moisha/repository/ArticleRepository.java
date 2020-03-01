package com.moisha.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.moisha.model.Article;

@Repository
public interface ArticleRepository {
  public List<Article> selectArticlesByInterestNo(
    @Param("interestNo") Long interestNo
    , @Param("offset") Integer offset
    , @Param("pageSize") Integer pageSize
  );
}
