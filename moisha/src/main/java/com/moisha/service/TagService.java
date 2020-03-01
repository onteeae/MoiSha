package com.moisha.service;

import com.moisha.model.Tag;
import com.moisha.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {
  @Autowired
  private TagRepository tagRepository;

  @Transactional
  public List<Tag> getTags() {
    List<Tag> tags = tagRepository.selectTagsAll();
    return tags;
  }

}
