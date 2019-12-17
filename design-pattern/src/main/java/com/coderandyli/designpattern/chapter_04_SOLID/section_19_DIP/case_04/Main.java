package com.coderandyli.designpattern.chapter_04_SOLID.section_19_DIP.case_04;


/**
 * Created by lizhen on 2019-12-17
 */
public class Main {
    public static void main(String args[]) {
        //使用Notification
        MessageSender messageSender = new MessageSender();
        Notification notification = new Notification(messageSender);
    }
}
