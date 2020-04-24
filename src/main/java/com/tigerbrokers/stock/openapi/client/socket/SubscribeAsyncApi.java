package com.tigerbrokers.stock.openapi.client.socket;

import com.tigerbrokers.stock.openapi.client.struct.enums.Exchange;
import com.tigerbrokers.stock.openapi.client.struct.enums.Subject;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * Created by lijiawen on 2018/08/29.
 */
public interface SubscribeAsyncApi {

  /**
   * subscribe trade data , include order / position / asset
   *
   * @param subject trade subject
   * @return string id
   */
  String subscribe(Subject subject);

  /**
   * subscribe trade data , include order / position / asset
   *
   * @param subject trade subject
   * @param focusKeys focus keys
   * @return string id
   */
  String subscribe(Subject subject, List<String> focusKeys);

  /**
   * subscribe trade data , include order / position / asset
   *
   * @param account subscribe account
   * @param subject trade subject
   * @return string id
   */
  String subscribe(String account, Subject subject);

  /**
   * subscribe trade data , include order / position / asset
   *
   * @param account account
   * @param subject subject
   * @param focusKeys focus keys
   * @return string id
   */
  String subscribe(String account, Subject subject, List<String> focusKeys);

  /**
   * cancel subscribe trade data , include order / position / asset
   *
   * @param subject trade subject
   * @return string id
   */
  String cancelSubscribe(Subject subject);

}
