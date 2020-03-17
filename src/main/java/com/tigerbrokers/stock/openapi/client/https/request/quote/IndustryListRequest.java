package com.tigerbrokers.stock.openapi.client.https.request.quote;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;
import com.tigerbrokers.stock.openapi.client.https.request.TigerCommonRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.quote.IndustryDetailResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.IndustryLevel;

/**
 * Description:
 *
 * @author kevin
 */
public class IndustryListRequest extends TigerCommonRequest implements TigerRequest<IndustryDetailResponse> {

  public IndustryListRequest(IndustryLevel industryLevel) {
    setApiVersion(V2_0);
    setApiMethodName(ApiServiceType.INDUSTRY_LIST);
    setApiModel(new IndustryListModel(industryLevel));
  }

  static class IndustryListModel extends ApiModel {

    private int industryLevel;

    public IndustryListModel(IndustryLevel industryLevel) {
      if (industryLevel == null) {
        throw new RuntimeException("industry level cannot be null");
      }
      this.industryLevel = industryLevel.getLevel();
    }

    public int getIndustryLevel() {
      return industryLevel;
    }
  }

  @Override
  public Class<IndustryDetailResponse> getResponseClass() {
    return IndustryDetailResponse.class;
  }
}
