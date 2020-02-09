package com.moisha.model;

import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@Data
public class Article {
  private Long articleNo;
  private String title;
  private Long interestNo;
  private String authorId;
  private DateTime createYmdt;
  private Integer viewCount;

  class CombinationSolver {

    public Map<Pair<Integer, Integer>, Integer> combinationMap = new HashMap<>();
    public Integer getCombinationBruteForce(int former, int later) {
      if (former == later || later == 0) return 1;
      return getCombinationBruteForce(former -1, later -1) + getCombinationBruteForce(former -1, later -1);
    }
    public Integer getCombinationDynamically(int former, int later) {
      if (former == later || later == 0) return 1;
      Pair<Integer, Integer> pair = new ImmutablePair<>(former, later);
      if (combinationMap.containsKey(pair)) {
        return combinationMap.get(pair);
      } else {
        int value = getCombinationDynamically(former - 1, later - 1)
                + getCombinationDynamically(former -1 , later);
        combinationMap.put(pair, value);
        return value;
      }
    }
  }
}
