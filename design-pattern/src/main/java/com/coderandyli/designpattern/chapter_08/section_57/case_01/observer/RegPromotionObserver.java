package com.coderandyli.designpattern.chapter_08.section_57.case_01.observer;

import com.google.common.eventbus.Subscribe;

/**
 * 注册体验金观察者
 */
public class RegPromotionObserver implements RegObserver {

    @Subscribe
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("Pass out experience coupons for successful registration");
    }
}
