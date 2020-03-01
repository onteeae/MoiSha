package com.moisha.model;

import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Article {
  private Long articleNo;
  private String title;
  private Long interestNo;
  private String authorId;
  private String contents;
  private DateTime createYmdt;
  private Integer viewCount;

  private List<Comment> comments;
}
