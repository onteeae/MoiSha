package com.moisha.repository;

import com.moisha.model.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository {
  public List<Tag> selectTagsAll(

  );
}
