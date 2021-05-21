package com.tigerbrokers.stock.openapi.client.https.request.quote;

import com.tigerbrokers.stock.openapi.client.constant.ApiServiceType;
import com.tigerbrokers.stock.openapi.client.https.domain.quote.model.QuoteDepthModel;
import com.tigerbrokers.stock.openapi.client.https.request.TigerCommonRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.quote.QuoteDepthResponse;
import java.util.List;

/**
 * 作者：ltc
 * 时间：2019/08/13
 */
public class QuoteDepthRequest extends TigerCommonRequest implements TigerRequest<QuoteDepthResponse> {

  public QuoteDepthRequest() {
    setApiVersion(V2_0);
    setApiMethodName(ApiServiceType.QUOTE_DEPTH);
  }

  public static QuoteDepthRequest newRequest(List<String> symbols, String market) {
    QuoteDepthRequest request = new QuoteDepthRequest();
    QuoteDepthModel quoteDepthModel = new QuoteDepthModel(symbols, market);
    request.setApiModel(quoteDepthModel);
    return request;
  }

  @Override
  public Class<QuoteDepthResponse> getResponseClass() {
    return QuoteDepthResponse.class;
  }
}
