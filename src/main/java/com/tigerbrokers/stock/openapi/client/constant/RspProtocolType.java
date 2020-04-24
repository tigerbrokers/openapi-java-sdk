package com.tigerbrokers.stock.openapi.client.constant;

/**
 * Description:
 * Created by lijiawen on 2018/05/23.
 */
public interface RspProtocolType {

  String RET_HEADER = "ret-type";

  int CONNECTION_END = -1;

  /**
   * 交易
   */
  int SUBSCRIBE_ORDER_STATUS = 9;
  int SUBSCRIBE_POSITION = 10;
  int SUBSCRIBE_ASSET = 11;

  /**
   * 行情
   */
  int GET_SUBSCRIBE_END = 112;
  int GET_CANCEL_SUBSCRIBE_END = 113;

  int ERROR_END = 200;
}
