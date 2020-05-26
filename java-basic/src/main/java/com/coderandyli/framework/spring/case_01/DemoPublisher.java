package com.coderandyli.framework.spring.case_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Publisher发送者 （被观察者）
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/26 上午11:45
 */
@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void publishEvent(DemoEvent demoEvent) {
        this.applicationContext.publishEvent(demoEvent);
    }
}