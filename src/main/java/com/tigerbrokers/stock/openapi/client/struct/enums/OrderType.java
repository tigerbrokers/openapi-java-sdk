package com.tigerbrokers.stock.openapi.client.struct.enums;

/**
 * Description:
 * Created by lijiawen on 2018/05/16.
 */
public enum OrderType {
  MKT("MKT", "MKT"),
  LMT("LMT", "LMT"),
  STP("STP", "STP"),
  STP_LMT("STP_LMT", "STP_LMT"),
  TRAIL("TRAIL", "TRAIL"),
  REL("REL", "REL"),
  RPI("RPI", "RPI"),
  LOC("LOC", "LOC"),
  MIT("MIT", "MIT"),
  LIT("LIT", "LIT"),
  MOC("MOC", "MOC"),
  SNAP_MID("SNAP_MID", "SNAP_MID"),
  SNAP_PRIM("SNAP_PRIM", "SNAP_PRIM"),
  TRAIL_LIMIT("TRAIL_LIMIT", "TRAIL_LIMIT"),
  MTL("MTL", "MTL"),
  LMT_MKT("LMT_+_MKT", "LMT MKT"),
  MIDPX("MIDPX", "MIDPX");

  private String type;
  private String desc;

  OrderType(String type, String desc) {
    this.type = type;
    this.desc = desc;
  }
}

