package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_19_DIP.case_03;

/**
 * Created by lizhen on 2019-12-17
 */

// 非依赖注入实现方式
public class Notification {
    private MessageSender messageSender;

    public Notification() {
        this.messageSender = new MessageSender(); //此处有点像hardcode（硬编码）
    }

    public void sendMessage(String cellphone, String message) {
        //...省略校验逻辑等...
        this.messageSender.send(cellphone, message);
    }
}
