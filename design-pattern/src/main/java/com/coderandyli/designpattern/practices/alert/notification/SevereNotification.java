package com.coderandyli.designpattern.practices.alert.notification;

import com.coderandyli.designpattern.practices.alert.msgSender.MsgSender;

public class SevereNotification extends Notification{
    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send("Level Severe Alert: " +  message);
    }
}
