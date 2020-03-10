package com.coderandyli.designpattern.practices.alert.msgSender;


import java.util.List;

public class TelephoneMsgSender implements MsgSender {
    private List<String> telephones;

    public TelephoneMsgSender(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public void send(String message) {
        System.out.println("【send alert msg by telephone】: " + message);
    }

}



//
//public abstract class Notification {
//    protected msgSender msgSender;
//
//    public Notification(msgSender msgSender) {
//        this.msgSender = msgSender;
//    }
//
//    public abstract void notify(String message);
//}
//
//public class SevereNotification extends Notification {
//    public SevereNotification(msgSender msgSender) {
//        super(msgSender);
//    }
//
//    @Override
//    public void notify(String message) {
//        msgSender.send(message);
//    }
//}
//
//public class UrgencyNotification extends Notification {
//    // 与SevereNotification代码结构类似，所以省略...
//}
//public class NormalNotification extends Notification {
//    // 与SevereNotification代码结构类似，所以省略...
//}
//public class TrivialNotification extends Notification {
//    // 与SevereNotification代码结构类似，所以省略...
//}