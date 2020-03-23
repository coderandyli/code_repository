package com.coderandyli.designpattern.chapter_08.section_56.case_02;

import com.coderandyli.designpattern.chapter_08.section_56.case_02.observer.RegNotificationObserver;
import com.coderandyli.designpattern.chapter_08.section_56.case_02.observer.RegObserver;
import com.coderandyli.designpattern.chapter_08.section_56.case_02.observer.RegPromotionObserver;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService; //依赖注入
    private List<RegObserver> regObservers = new ArrayList<>();

    /**
     * register observer
     */
    public void registerRegObservers() {
        regObservers.add(new RegNotificationObserver());
        regObservers.add(new RegPromotionObserver());
    }

    public long register(String telephone, String password) {
        // Ignore judgment logic...
        long userId = userService.register(telephone, password);

        // handles the registration logic
        for (RegObserver regObserver : regObservers) {
            regObserver.handleRegSuccess(userId);
        }
        return userId;
    }
}
