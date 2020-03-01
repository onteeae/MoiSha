package com.moisha.model;

import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

@Data
public class Comment {
    private Long commentNo;
    private String contents;
    private String authorId;
    private DateTime createYmdt;

}
