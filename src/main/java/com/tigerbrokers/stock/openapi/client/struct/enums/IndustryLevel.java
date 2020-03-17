package com.tigerbrokers.stock.openapi.client.struct.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author kevin
 */
public enum IndustryLevel {
  GSECTOR(1),
  GGROUP(2),
  GIND(3),
  GSUBIND(4);

  private int level;

  private static final Map<Integer, IndustryLevel> LEVEL_MAP = new HashMap<>();

  static {
    for (IndustryLevel industryLevel : values()) {
      LEVEL_MAP.put(industryLevel.level, industryLevel);
    }
  }

  IndustryLevel(int level) {
    this.level = level;
  }

  public static IndustryLevel getByLevel(int level) {
    return LEVEL_MAP.get(level);
  }

  public int getLevel() {
    return level;
  }
}
