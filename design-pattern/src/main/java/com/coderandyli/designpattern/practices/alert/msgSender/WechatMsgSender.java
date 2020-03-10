package com.coderandyli.designpattern.practices.alert.msgSender;

public class WechatMsgSender implements MsgSender {
    @Override
    public void send(String message) {
        System.out.println("【send alert msg by wechat】: " + message);
    }
}
