package com.coderandyli.designpattern.chapter_08.section_57.case_01.observer;

import com.google.common.eventbus.Subscribe;

/**
 * 注册站内信观察者
 */
public class RegNotificationObserver implements RegObserver {
    @Subscribe
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("send a msg of successfully registration");
    }
}
