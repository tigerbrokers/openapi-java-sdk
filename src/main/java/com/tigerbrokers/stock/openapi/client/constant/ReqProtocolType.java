package com.tigerbrokers.stock.openapi.client.constant;

/**
 * Description:
 * Created by lijiawen on 2018/05/22.
 */
public interface ReqProtocolType {

  String REQ_HEADER = "req-type";

  /**
   * 交易
   */
  int ORDER_NO = 1;
  int PREVIEW_ORDER = 2;
  int PLACE_ORDER = 3;
  int CANCEL_ORDER = 4;
  int MODIFY_ORDER = 5;
  int REQ_OPEN_ORDERS = 6;
  int REQ_ASSETS = 7;
  int REQ_POSITIONS = 8;
  int REQ_ACCOUNT = 9;

  /**
   * 行情
   */
  int REQ_SUB_SYMBOLS = 110;
}
