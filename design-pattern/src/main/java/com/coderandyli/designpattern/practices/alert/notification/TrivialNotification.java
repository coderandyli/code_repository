package com.coderandyli.designpattern.practices.alert.notification;

import com.coderandyli.designpattern.practices.alert.msgSender.MsgSender;

public class TrivialNotification extends Notification {
    public TrivialNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send("Level Trivial Alert: " +  message);
    }
}
