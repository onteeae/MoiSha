package com.moisha.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moisha.model.Comment;
import com.moisha.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public List<Comment> getCommentsByArticle(Long articleNo) {
        List<Comment> comments = commentRepository.selectCommentsByArticleNo(articleNo);
        return comments;
    }

}
