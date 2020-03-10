package com.coderandyli.designpattern.practices.alert.msgSender;


import java.util.List;

public class EmailMsgSender implements MsgSender {
    private List<String> telephones;
    public EmailMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("【send alert msg by email】: " + message);
    }
}
