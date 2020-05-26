package com.coderandyli.framework.spring.case_01;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Listener监听者 （观察者）
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/26 上午11:45
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String message = demoEvent.getMessage();
        System.out.println(message);
    }
}
