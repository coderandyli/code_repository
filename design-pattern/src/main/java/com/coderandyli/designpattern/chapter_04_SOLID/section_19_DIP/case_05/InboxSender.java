package com.coderandyli.designpattern.chapter_04_SOLID.section_19_DIP.case_05;

/**
 * Created by lizhen on 2019-12-17
 * 站内信发送类
 */
public class InboxSender implements MessageSender {
    @Override
    public void send(String cellphone, String message) {
        System.out.println("send inbox");
    }
}
