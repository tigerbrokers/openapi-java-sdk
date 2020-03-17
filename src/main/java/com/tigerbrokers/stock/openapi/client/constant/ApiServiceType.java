package com.tigerbrokers.stock.openapi.client.constant;

/**
 * Description:
 * Created by lijiawen on 2018/05/31.
 */
public interface ApiServiceType {

  /**
   * 交易
   */
  String ORDER_NO = "order_no";
  String PREVIEW_ORDER = "preview_order";
  String PLACE_ORDER = "place_order";
  String BATCH_PLACE_ORDER = "batch_place_order";
  String CANCEL_ORDER = "cancel_order";
  String MODIFY_ORDER = "modify_order";

  /**
   * 行情
   */
  String MARKET_STATE = "market_state";
  String ALL_SYMBOLS = "all_symbols";
  String ALL_SYMBOL_NAMES = "all_symbol_names";
  String BRIEF = "brief";
  String STOCK_DETAIL = "stock_detail";
  String HOUR_TRADING_TIMELINE = "hour_trading_timeline";

  String TIMELINE = "timeline";
  String KLINE = "kline";
  String TRADE_TICK = "trade_tick";
  String QUOTE_CONTRACT = "quote_contract";
  String QUOTE_REAL_TIME = "quote_real_time";
  String QUOTE_SHORTABLE_STOCKS = "quote_shortable_stocks";
  String QUOTE_STOCK_TRADE = "quote_stock_trade";
  String ASK_BID = "ask_bid";
  String INDUSTRY_LIST = "industry_list";
  String INDUSTRY_STOCKS = "industry_stocks";
  String STOCK_INDUSTRY = "stock_industry";

  /**
   * 期权行情
   */
  String OPTION_EXPIRATION = "option_expiration";
  String OPTION_CHAIN = "option_chain";
  String OPTION_BRIEF = "option_brief";
  String OPTION_KLINE = "option_kline";
  String OPTION_TRADE_TICK = "option_trade_tick";

  /**
   * 期货行情
   */
  String FUTURE_EXCHANGE = "future_exchange";
  String FUTURE_CONTRACT_BY_CONTRACT_CODE = "future_contract_by_contract_code";
  String FUTURE_CONTRACT_BY_EXCHANGE_CODE = "future_contract_by_exchange_code";
  String FUTURE_CONTINUOUS_CONTRACTS = "future_continuous_contracts";
  String FUTURE_CURRENT_CONTRACT = "future_current_contract";
  String FUTURE_KLINE = "future_kline";
  String FUTURE_REAL_TIME_QUOTE = "future_real_time_quote";
  String FUTURE_TICK = "future_tick";
  String FUTURE_TRADING_DATE = "future_trading_date";

  /**
   * 账户/资产
   */
  String ACCOUNTS = "accounts";
  String ASSETS = "assets";
  String POSITIONS = "positions";
  String ORDERS = "orders";
  String ACTIVE_ORDERS = "active_orders";
  String INACTIVE_ORDERS = "inactive_orders";
  String FILLED_ORDERS = "filled_orders";

  /**
   * 合约
   */
  String CONTRACT = "contract";
  String CONTRACTS = "contracts";

  /**
   * 基础数据
   */
  String FINANCIAL_DAILY = "financial_daily";
  String FINANCIAL_REPORT = "financial_report";
  String CORPORATE_ACTION = "corporate_action";

  /**
   * 用户
   */
  String USER_LOGIN = "user_login";
  String USER_TRADE_TOKEN = "user_trade_token";
  String USER_TRADE_PASSWORD_VERIFY = "user_trade_password_verify";
  String USER_TRADE_PASSWORD_RESET = "user_trade_password_reset";
}
