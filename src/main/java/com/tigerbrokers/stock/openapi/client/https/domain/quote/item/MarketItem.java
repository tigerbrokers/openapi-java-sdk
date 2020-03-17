package com.tigerbrokers.stock.openapi.client.https.domain.quote.item;

import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;

/**
 * Description:
 * Created by lijiawen on 2018/12/25.
 */
public class MarketItem extends ApiModel {

  /**
   * US:美股，CN:沪深，HK:港股
   **/
  private String market;

  /**
   * market status detail
   **/
  private String marketStatus;

  /**
   * market status(NOT_YET_OPEN,PRE_HOUR_TRADING,TRADING,MIDDLE_CLOSE,POST_HOUR_TRADING,CLOSING,EARLY_CLOSED,MARKET_CLOSED）
   */
  private String status;

  /**
   * 最近开盘、交易时间  MM-dd HH:mm:ss z
   **/
  private String openTime;

  public String getMarket() {
    return market;
  }

  public void setMarket(String market) {
    this.market = market;
  }

  public String getMarketStatus() {
    return marketStatus;
  }

  public void setMarketStatus(String marketStatus) {
    this.marketStatus = marketStatus;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getOpenTime() {
    return openTime;
  }

  public void setOpenTime(String openTime) {
    this.openTime = openTime;
  }

  @Override
  public String toString() {
    return "MarketItem{" +
        "market='" + market + '\'' +
        ", marketStatus='" + marketStatus + '\'' +
        ", status='" + status + '\'' +
        ", openTime='" + openTime + '\'' +
        '}';
  }
}
