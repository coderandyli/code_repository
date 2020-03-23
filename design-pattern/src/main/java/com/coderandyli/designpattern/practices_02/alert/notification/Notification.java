package com.coderandyli.designpattern.practices_02.alert.notification;

import com.coderandyli.designpattern.practices_02.alert.sender.MsgSender;

/**
 * 通知类
 */
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String msg);
}
