package com.tigerbrokers.stock.openapi.client.https.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tigerbrokers.stock.openapi.client.TigerApiException;
import com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants;
import com.tigerbrokers.stock.openapi.client.https.domain.ApiModel;
import com.tigerbrokers.stock.openapi.client.https.domain.BatchApiModel;
import com.tigerbrokers.stock.openapi.client.https.request.TigerHttpRequest;
import com.tigerbrokers.stock.openapi.client.https.request.TigerRequest;
import com.tigerbrokers.stock.openapi.client.https.response.TigerResponse;
import com.tigerbrokers.stock.openapi.client.struct.enums.AccountType;
import com.tigerbrokers.stock.openapi.client.struct.enums.TigerApiCode;
import com.tigerbrokers.stock.openapi.client.util.ApiLogger;
import com.tigerbrokers.stock.openapi.client.util.HttpUtils;
import com.tigerbrokers.stock.openapi.client.util.StringUtils;
import com.tigerbrokers.stock.openapi.client.util.TigerSignature;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.ACCESS_TOKEN;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.ACCOUNT_TYPE;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.BIZ_CONTENT;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.CHARSET;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.METHOD;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.SIGN;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.SIGN_TYPE;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.TIGER_ID;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.TIMESTAMP;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.TRADE_TOKEN;
import static com.tigerbrokers.stock.openapi.client.constant.TigerApiConstants.VERSION;

/**
 * HTTP客户端
 */
public class TigerHttpClient implements TigerClient {

  private String serverUrl;
  private String tigerId;
  private String privateKey;
  private String tigerPublicKey;
  private String accessToken;
  private String tradeToken;
  private String accountType;

  private static final String ONLINE_PUBLIC_KEY =
      "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNF3G8SoEcCZh2rshUbayDgLLrj6rKgzNMxDL2HSnKcB0+GPOsndqSv+a4IBu9+I3fyBp5hkyMMG2+AXugd9pMpy6VxJxlNjhX1MYbNTZJUT4nudki4uh+LMOkIBHOceGNXjgB+cXqmlUnjlqha/HgboeHSnSgpM3dKSJQlIOsDwIDAQAB";

  private static final String SANDBOX_PUBLIC_KEY =
      "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbm21i11hgAENGd3/f280PSe4g9YGkS3TEXBYMidihTvHHf+tJ0PYD0o3PruI0hl3qhEjHTAxb75T5YD3SGK4IBhHn/Rk6mhqlGgI+bBrBVYaXixmHfRo75RpUUuWACyeqQkZckgR0McxuW9xRMIa2cXZOoL1E4SL4lXKGhKoWbwIDAQAB";

  private String signType = TigerApiConstants.SIGN_TYPE_RSA;
  private String charset = TigerApiConstants.CHARSET_UTF8;

  static {
    Security.setProperty("jdk.certpath.disabledAlgorithms", "");
  }

  public TigerHttpClient(String serverUrl, String tigerId, String privateKey) {
    if (serverUrl == null) {
      throw new RuntimeException("serverUrl is empty.");
    }
    if (tigerId == null) {
      throw new RuntimeException("tigerId is empty.");
    }
    if (privateKey == null) {
      throw new RuntimeException("privateKey is empty.");
    }
    this.serverUrl = serverUrl;
    this.tigerId = tigerId;
    this.privateKey = privateKey;
    if (serverUrl.contains("openapi.itiger")) {
      this.tigerPublicKey = ONLINE_PUBLIC_KEY;
    } else {
      this.tigerPublicKey = SANDBOX_PUBLIC_KEY;
    }
  }

  public TigerHttpClient(String serverUrl, String tigerId, String privateKey, String tigerPublicKey) {
    if (serverUrl == null) {
      throw new RuntimeException("serverUrl is empty.");
    }
    if (tigerId == null) {
      throw new RuntimeException("tigerId is empty.");
    }
    if (privateKey == null) {
      throw new RuntimeException("privateKey is empty.");
    }
    if (tigerPublicKey == null) {
      throw new RuntimeException("tigerPublicKey is empty.");
    }

    this.serverUrl = serverUrl;
    this.tigerId = tigerId;
    this.privateKey = privateKey;
    this.tigerPublicKey = tigerPublicKey;
  }

  public TigerHttpClient(String serverUrl) {
    this.serverUrl = serverUrl;
  }

  public TigerHttpClient(String serverUrl, String accessToken) {
    this.serverUrl = serverUrl;
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public void setTradeToken(String tradeToken) {
    this.tradeToken = tradeToken;
  }

  public String getTradeToken() {
    return tradeToken;
  }

  public void setAccountType(AccountType accountType) {
    if (accountType != null) {
      this.accountType = accountType.name();
    }
  }

  public String getAccountType() {
    return accountType;
  }

  public <T extends TigerResponse> T execute(TigerRequest<T> request) {
    T response;
    String param = null;
    String data = null;
    try {
      param = JSONObject.toJSONString(buildParams(request));
      ApiLogger.debug("request param:{}", param);

      data = HttpUtils.post(serverUrl, param);

      if (StringUtils.isEmpty(data)) {
        return null;
      }
      response = JSON.parseObject(data, request.getResponseClass());

      if (StringUtils.isEmpty(this.tigerPublicKey) || response.getSign() == null) {
        return response;
      }
      boolean signSuccess =
          TigerSignature.rsaCheckContent(request.getTimestamp(), response.getSign(), this.tigerPublicKey, this.charset);

      if (!signSuccess) {
        throw new TigerApiException(TigerApiCode.SIGN_CHECK_FAILED);
      }
      return response;
    } catch (RuntimeException e) {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), param, data, e);
      return errorResponse(tigerId, request, e);
    } catch (TigerApiException e) {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), param, data, e);
      return errorResponse(tigerId, request, e);
    } catch (Exception e) {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), param, data, e);
      return errorResponse(tigerId, request, e);
    }
  }

  private <T extends TigerResponse> T errorResponse(String tigerId, TigerRequest<T> request, TigerApiException e) {
    try {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), e);

      T response = request.getResponseClass().newInstance();
      response.setCode(e.getErrCode());
      response.setMessage(e.getErrMsg());
      return response;
    } catch (Exception e1) {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), e1);
      return null;
    }
  }

  private <T extends TigerResponse> T errorResponse(String tigerId, TigerRequest<T> request, Exception e) {
    try {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), e);

      T response = request.getResponseClass().newInstance();
      response.setCode(TigerApiCode.CLIENT_API_ERROR.getCode());
      response.setMessage(TigerApiCode.CLIENT_API_ERROR.getMessage() + "(" + e.getMessage() + ")");
      return response;
    } catch (Exception e1) {
      ApiLogger.error(tigerId, request.getApiMethodName(), request.getApiVersion(), e1);
      return null;
    }
  }

  private Map<String, Object> buildParams(TigerRequest request) {
    Map params = new HashMap<>();
    params.put(METHOD, request.getApiMethodName());
    params.put(VERSION, request.getApiVersion());
    if (request instanceof TigerHttpRequest) {
      params.put(BIZ_CONTENT, ((TigerHttpRequest) request).getBizContent());
    } else {
      ApiModel apiModel = request.getApiModel();
      if (apiModel instanceof BatchApiModel) {
        params.put(BIZ_CONTENT, JSONObject.toJSONString(((BatchApiModel) apiModel).getItems()));
      } else {
        params.put(BIZ_CONTENT, JSONObject.toJSONString(apiModel));
      }
    }
    params.put(TIMESTAMP, request.getTimestamp());
    params.put(CHARSET, this.charset);
    params.put(TIGER_ID, this.tigerId);
    params.put(SIGN_TYPE, this.signType);
    if (this.accessToken != null) {
      params.put(ACCESS_TOKEN, this.accessToken);
    }
    if (this.tradeToken != null) {
      params.put(TRADE_TOKEN, this.tradeToken);
    }
    if (this.accountType != null) {
      params.put(ACCOUNT_TYPE, this.accountType);
    }
    if (this.tigerId != null) {
      String signContent = TigerSignature.getSignContent(params);
      String sign = TigerSignature.rsaSign(signContent, privateKey, charset);
      params.put(SIGN, sign);
    }

    return params;
  }
}
