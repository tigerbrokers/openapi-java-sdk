package com.tigerbrokers.stock.openapi.client.https.request.quote;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;
import com.tigerbrokers.stock.openapi.client.https.request.TigerCommonRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.quote.SymbolIndustryResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.Market;

/**
 * Description:
 *
 * @author kevin
 */
public class IndustryStocksRequest extends TigerCommonRequest implements TigerRequest<SymbolIndustryResponse> {

  public IndustryStocksRequest(Integer industryId, Market market) {
    setApiVersion(V2_0);
    setApiMethodName(ApiServiceType.INDUSTRY_STOCKS);
    setApiModel(new IndustryStocksModel(industryId, market));
  }

  static class IndustryStocksModel extends ApiModel {

    private Integer industryId;
    private Market market;

    public IndustryStocksModel(Integer industryId, Market market) {
      this.industryId = industryId;
      this.market = market;
    }

    public Integer getIndustryId() {
      return industryId;
    }

    public Market getMarket() {
      return market;
    }
  }

  @Override
  public Class<SymbolIndustryResponse> getResponseClass() {
    return SymbolIndustryResponse.class;
  }
}
