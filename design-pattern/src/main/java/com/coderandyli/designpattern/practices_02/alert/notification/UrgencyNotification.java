package com.coderandyli.designpattern.practices_02.alert.notification;

import com.coderandyli.designpattern.practices_02.alert.sender.MsgSender;

public class UrgencyNotification extends Notification {
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSender.send("Urgency alert: " + msg);
    }
}
