package com.moisha.controller;

import javax.websocket.server.PathParam;

import com.moisha.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.moisha.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("comments/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "article/{articleNo}", method = RequestMethod.GET)
    public List<Comment> getComments(@PathVariable("articleNo") Long articleNo) {
        List<Comment> comments = commentService.getCommentsByArticle(articleNo);
        return comments;
    }
}
