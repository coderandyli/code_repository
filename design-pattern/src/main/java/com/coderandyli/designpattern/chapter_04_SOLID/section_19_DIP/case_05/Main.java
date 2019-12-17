package com.coderandyli.designpattern.chapter_04_SOLID.section_19_DIP.case_05;

/**
 * Created by lizhen on 2019-12-17
 * 将MessageSender抽象成接口，增加扩展性
 */
public class Main {
    public static void main(String args[]) {
        MessageSender smsSender = new SmsSender();
        Notification notification1 = new Notification(smsSender);

        MessageSender inboxSender = new InboxSender();
        Notification notification2 = new Notification(inboxSender);
    }
}
