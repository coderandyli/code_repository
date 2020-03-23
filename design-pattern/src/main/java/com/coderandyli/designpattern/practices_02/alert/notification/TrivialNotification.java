package com.coderandyli.designpattern.practices_02.alert.notification;

import com.coderandyli.designpattern.practices_02.alert.sender.MsgSender;

public class TrivialNotification extends Notification {
    public TrivialNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSender.send("Trivial alert: " + msg);
    }
}
