package com.coderandyli.framework.spring.case_01;

import org.springframework.context.ApplicationEvent;

/**
 * Event事件
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/26 上午11:44
 */
public class DemoEvent extends ApplicationEvent {
    private String message;

    public DemoEvent(Object source, String message) {
        super(source);
    }

    public String getMessage() {
        return this.message;
    }
}



