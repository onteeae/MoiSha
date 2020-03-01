package com.moisha.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

@Data
public class Tag {
  private Long tagNo;
  private String name;
  private String color;
}
