package com.coderandyli.designpattern.chapter_08.section_57.case_01;

import com.coderandyli.designpattern.chapter_08.section_57.case_01.observer.RegNotificationObserver;
import com.coderandyli.designpattern.chapter_08.section_57.case_01.observer.RegPromotionObserver;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class UserController {
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    private UserService userService; //依赖注入
    private EventBus eventBus;
    private List<Object> regObservers = new ArrayList<>();

    public UserController() {
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE)); // 异步非阻塞模式
        registerRegObservers();
        setRegObservers(this.regObservers);
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    /**
     * register observer
     */
    public void registerRegObservers() {
        regObservers.add(new RegNotificationObserver());
        regObservers.add(new RegPromotionObserver());
    }

    public long register(String telephone, String password) {
        // Ignore judgment logic...
        long userId = 1122; //userService.register(telephone, password);
        registerRegObservers();

        // handles the registration logic
        eventBus.post(userId);
        return userId;
    }


}
