package com.coderandyli.designpattern.practices.alert.notification;

import com.coderandyli.designpattern.practices.alert.msgSender.MsgSender;

public class NormalNotification extends Notification {
    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send("Level Normal Alert: " +  message);
    }
}
