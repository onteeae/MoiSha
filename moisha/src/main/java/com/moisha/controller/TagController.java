package com.moisha.controller;

import com.moisha.model.Tag;
import com.moisha.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

  @Autowired
  private TagService tagService;

  @RequestMapping()
  public List<Tag> getTags() {
    List<Tag> tags = tagService.getTags();
    return tags;
  }
}
