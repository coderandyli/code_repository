package com.coderandyli.designpattern.chapter_08.section_56.case_02.observer;

/**
 * 注册体验金观察者
 */
public class RegPromotionObserver implements RegObserver {
    @Override
    public void handleRegSuccess(long userId) {
        System.out.println("Pass out experience coupons for successful registration");
    }
}
