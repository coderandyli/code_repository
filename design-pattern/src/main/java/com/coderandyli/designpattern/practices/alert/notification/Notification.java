package com.coderandyli.designpattern.practices.alert.notification;


import com.coderandyli.designpattern.practices.alert.msgSender.MsgSender;

public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);

//    private List<String> emailAddresses;
//    private List<String> telephones;
//    private List<String> wechatIds;
//
//    public void setEmailAddresses(List<String> emailAddresses) {
//        this.emailAddresses = emailAddresses;
//    }
//
//    public void setTelephones(List<String> telephones) {
//        this.telephones = telephones;
//    }
//
//    public void setWechatIds(List<String> wechatIds) {
//        this.wechatIds = wechatIds;
//    }
//
//    public void notify(NotificationEmergencyLevel level, String message) {
//        System.out.println(message);
//        switch (level) {
//            case SEVERE:
//                // ... 自动语音电话通知 ...
//                break;
//            case URGENCY:
//                // ... 微信通知 ...
//                break;
//            case NORMAL:
//                // ... 邮件通知 ...
//                break;
//            case TRIVIAL:
//                // ... 邮件通知 ...
//                break;
//            default:
//                break;
//        }
//
//    }
}
