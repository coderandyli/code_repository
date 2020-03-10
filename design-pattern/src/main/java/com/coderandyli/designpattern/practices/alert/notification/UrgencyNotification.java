package com.coderandyli.designpattern.practices.alert.notification;

import com.coderandyli.designpattern.practices.alert.msgSender.MsgSender;

public class UrgencyNotification extends Notification {
    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send("Level Urgency Alert: " +  message);
    }
}
