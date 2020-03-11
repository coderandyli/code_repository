package com.coderandyli.designpattern.practices.alert.msgSender;


import java.util.List;

public class TelephoneMsgSender implements MsgSender {
    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("【send alert msg by telephone】: " + message);
    }
}