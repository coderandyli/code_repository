package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_19_DIP.case_05;


/**
 * Created by lizhen on 2019-12-17
 */

// 依赖注入的实现方式
public class Notification {
    private MessageSender messageSender;

    // 通过构造函数将messageSender传递进来
    public Notification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendMessage(String cellphone, String message) {
        //...省略校验逻辑等...
        this.messageSender.send(cellphone, message);
    }
}
