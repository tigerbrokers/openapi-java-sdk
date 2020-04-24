package com.tigerbrokers.stock.openapi.client.socket;

import com.alibaba.fastjson.JSONObject;

/**
 * Description:
 * Created by lijiawen on 2018/08/29.
 */
public interface SubscribeApiCallback {

  void orderStatusChange(JSONObject jsonObject);

  void positionChange(JSONObject jsonObject);

  void assetChange(JSONObject jsonObject);

  void subscribeEnd(JSONObject jsonObject);

  void cancelSubscribeEnd(JSONObject jsonObject);
}
