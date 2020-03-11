package com.coderandyli.designpattern.chapter_08.section_56.case_02.observer;

/**
 * 注册站内信观察者
 */
public class RegNotificationObserver implements RegObserver {
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("send a msg of successfully registration");
    }
}
