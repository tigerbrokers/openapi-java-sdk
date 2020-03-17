package com.tigerbrokers.stock.openapi.client.https.response.quote;

import com.alibaba.fastjson.annotation.JSONField;
import com.tigerbrokers.stock.openapi.client.https.domain.quote.item.SymbolIndustryItem;
import com.tigerbrokers.stock.openapi.client.https.response.TigerResponse;
import java.util.List;

/**
 * Description:
 *
 * @author kevin
 */
public class SymbolIndustryResponse extends TigerResponse {

  @JSONField(name = "data")
  private List<SymbolIndustryItem> items;

  public List<SymbolIndustryItem> getItems() {
    return items;
  }

  public void setItems(List<SymbolIndustryItem> items) {
    this.items = items;
  }
}
