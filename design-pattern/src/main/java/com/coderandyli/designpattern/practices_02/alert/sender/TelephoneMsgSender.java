package com.coderandyli.designpattern.practices_02.alert.sender;

import java.util.List;

public class TelephoneMsgSender implements MsgSender {
    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String msg) {
        System.out.println("send alert msg by telephone");
    }
}
