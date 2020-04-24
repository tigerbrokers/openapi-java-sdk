package com.tigerbrokers.stock.openapi.client.util;

import com.tigerbrokers.stock.openapi.client.struct.enums.Subject;
import com.tigerbrokers.stock.openapi.client.util.builder.StompHeaderBuilder;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.stomp.DefaultStompFrame;
import io.netty.handler.codec.stomp.StompCommand;
import io.netty.handler.codec.stomp.StompFrame;
import io.netty.handler.codec.stomp.StompHeaders;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * Created by lijiawen on 2018/05/23.
 */
public class StompMessageUtil {

  private static AtomicInteger increment = new AtomicInteger(0);

  public static StompFrame buildConnectMessage(String login, String passcode, String version) {
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.CONNECT);
    stompFrame.headers()
        .set(StompHeaderBuilder.instance().version(version).host().login(login).passcode(passcode).build());
    return stompFrame;
  }

  /**
   * @param login login
   * @param passcode passcode
   * @param version version
   * @param sendInterval client能保证发送心跳的最小间隔，0代表client不发送心跳
   * @param receiveInterval client希望收到server心跳的间隔，0代表client不希望收到server的心跳
   * @return StompFrame
   */
  public static StompFrame buildConnectMessage(String login, String passcode, String version, int sendInterval,
      int receiveInterval) {
    if (sendInterval < 0 || receiveInterval < 0) {
      throw new RuntimeException("sendInterval < 0 or receiveInterval < 0");
    }
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.CONNECT);
    stompFrame.headers()
        .set(StompHeaderBuilder.instance()
            .version(version)
            .host()
            .login(login)
            .passcode(passcode)
            .heartBeat(sendInterval, receiveInterval)
            .build());
    return stompFrame;
  }

  public static StompFrame buildSendMessage(int reqType, String message) {
    if (reqType <= 0) {
      throw new RuntimeException("reqType不能为空");
    }
    StompFrame stompFrame;
    int id = increment.addAndGet(1);
    if (message != null) {
      stompFrame =
          new DefaultStompFrame(StompCommand.SEND, Unpooled.wrappedBuffer(message.getBytes(Charset.defaultCharset())));
    } else {
      stompFrame = new DefaultStompFrame(StompCommand.SEND);
    }
    StompHeaders headers = StompHeaderBuilder.instance().id(id).version().host().reqType(reqType).build();
    stompFrame.headers().set(headers);

    return stompFrame;
  }

  public static StompFrame buildCommonSendMessage(String message) {
    StompFrame stompFrame;
    int id = increment.addAndGet(1);
    if (message != null) {
      stompFrame =
          new DefaultStompFrame(StompCommand.SEND, Unpooled.wrappedBuffer(message.getBytes(Charset.defaultCharset())));
    } else {
      stompFrame = new DefaultStompFrame(StompCommand.SEND);
    }
    StompHeaders headers = StompHeaderBuilder.instance().id(id).version().host().build();
    stompFrame.headers().set(headers);

    return stompFrame;
  }

  public static StompFrame buildSubscribeMessage(Subject subject) {
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.SUBSCRIBE);
    int id = increment.addAndGet(1);
    StompHeaders headers = StompHeaderBuilder.instance().id(id).version().host().subject(subject).build();
    stompFrame.headers().set(headers);
    return stompFrame;
  }

  public static StompFrame buildSubscribeMessage(String account, Subject subject, Set<String> focusKeys) {
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.SUBSCRIBE);
    int id = increment.addAndGet(1);
    StompHeaders headers = StompHeaderBuilder.instance()
        .id(id)
        .version()
        .account(account)
        .host()
        .subject(subject)
        .focusKeys(focusKeys)
        .build();
    stompFrame.headers().set(headers);
    return stompFrame;
  }

  public static StompFrame buildSubscribeMessage(Subject subject, Set<String> focusKeys) {
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.SUBSCRIBE);
    int id = increment.addAndGet(1);
    StompHeaders headers =
        StompHeaderBuilder.instance().id(id).version().host().subject(subject).focusKeys(focusKeys).build();
    stompFrame.headers().set(headers);
    return stompFrame;
  }

  public static StompFrame buildUnSubscribeMessage(Subject subject) {
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.UNSUBSCRIBE);
    int id = increment.addAndGet(1);
    StompHeaders headers = StompHeaderBuilder.instance().id(id).version().host().subject(subject).build();
    stompFrame.headers().set(headers);
    return stompFrame;
  }

  public static StompFrame buildDisconnectMessage(String login) {
    StompFrame stompFrame = new DefaultStompFrame(StompCommand.DISCONNECT);
    StompHeaders headers = StompHeaderBuilder.instance().login(login).version().host().build();
    stompFrame.headers().set(headers);
    return stompFrame;
  }
}
