package com.tigerbrokers.stock.openapi.client.https.request.quote;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;
import com.tigerbrokers.stock.openapi.client.https.request.TigerCommonRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.quote.IndustryDetailResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.Market;

/**
 * Description:
 *
 * @author kevin
 */
public class StockIndustryRequest extends TigerCommonRequest implements TigerRequest<IndustryDetailResponse> {

  public StockIndustryRequest(String symbol, Market market) {
    setApiVersion(V2_0);
    setApiMethodName(ApiServiceType.STOCK_INDUSTRY);
    setApiModel(new StockIndustryModel(symbol, market));
  }

  static class StockIndustryModel extends ApiModel {

    private String symbol;
    private Market market;

    public StockIndustryModel(String symbol, Market market) {
      this.symbol = symbol;
      this.market = market;
    }

    public String getSymbol() {
      return symbol;
    }

    public Market getMarket() {
      return market;
    }
  }

  @Override
  public Class<IndustryDetailResponse> getResponseClass() {
    return IndustryDetailResponse.class;
  }
}
