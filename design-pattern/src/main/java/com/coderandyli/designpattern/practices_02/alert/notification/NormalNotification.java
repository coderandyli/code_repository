package com.coderandyli.designpattern.practices_02.alert.notification;

import com.coderandyli.designpattern.practices_02.alert.sender.MsgSender;

public class NormalNotification extends Notification {
    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSender.send("Normal alert: " + msg);
    }
}
