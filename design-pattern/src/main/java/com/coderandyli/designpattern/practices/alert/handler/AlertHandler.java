package com.coderandyli.designpattern.practices.alert.handler;


import com.coderandyli.designpattern.practices.alert.AlertRule;
import com.coderandyli.designpattern.practices.alert.notification.Notification;

/**
 * Created by lizhen on 2019-12-14
 *
 *  警告处理抽象类
 */
public abstract class AlertHandler {
    protected AlertRule rule;
    protected Notification notification;
    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }
    public abstract void check(ApiStatInfo apiStatInfo);
}
