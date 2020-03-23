package com.coderandyli.designpattern.practices_02.alert.sender;

import java.util.List;

public class EmailMsgSender implements MsgSender {
    private List<String> emails;

    public EmailMsgSender(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public void send(String msg) {
        System.out.println("send alert msg by email");
    }
}
