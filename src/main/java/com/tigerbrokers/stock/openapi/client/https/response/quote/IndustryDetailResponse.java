package com.tigerbrokers.stock.openapi.client.https.response.quote;

import com.alibaba.fastjson.annotation.JSONField;
import com.tigerbrokers.stock.openapi.client.https.domain.quote.item.IndustryDetailItem;
import com.tigerbrokers.stock.openapi.client.https.response.TigerResponse;
import java.util.List;

/**
 * Description:
 *
 * @author kevin
 */
public class IndustryDetailResponse extends TigerResponse {

  @JSONField(name = "data")
  private List<IndustryDetailItem> items;

  public List<IndustryDetailItem> getItems() {
    return items;
  }

  public void setItems(List<IndustryDetailItem> items) {
    this.items = items;
  }
}
