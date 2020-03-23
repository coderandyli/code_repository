package com.coderandyli.designpattern.practices_02.alert.notification;

import com.coderandyli.designpattern.practices_02.alert.sender.MsgSender;

public class SevereNotification extends Notification {

    public SevereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String msg) {
        msgSender.send("Severe alert: " + msg);
    }
}
