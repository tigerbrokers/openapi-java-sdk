package com.tigerbrokers.stock.openapi.client.https.domain.quote.item;

import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;
import com.tigerbrokers.stock.openapi.client.struct.enums.Market;
import java.util.List;

/**
 * Description:
 *
 * @author kevin
 */
public class SymbolIndustryItem extends ApiModel {

  private String symbol;
  private Market market;
  private String companyName;
  private List<IndustryDetailItem> industryDetailDTOList;

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Market getMarket() {
    return market;
  }

  public void setMarket(Market market) {
    this.market = market;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public List<IndustryDetailItem> getIndustryDetailDTOList() {
    return industryDetailDTOList;
  }

  public void setIndustryDetailDTOList(
      List<IndustryDetailItem> industryDetailDTOList) {
    this.industryDetailDTOList = industryDetailDTOList;
  }

  @Override
  public String toString() {
    return "SymbolIndustryItem{" +
        "symbol='" + symbol + '\'' +
        ", market=" + market +
        ", companyName='" + companyName + '\'' +
        ", industryDetailDTOList=" + industryDetailDTOList +
        '}';
  }
}
