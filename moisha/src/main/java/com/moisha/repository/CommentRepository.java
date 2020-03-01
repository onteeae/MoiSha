package com.moisha.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.moisha.model.Comment;

@Repository
public interface CommentRepository {
    public List<Comment> selectCommentsByArticleNo(
            @Param("articleNo") Long articleNo
    );


}
