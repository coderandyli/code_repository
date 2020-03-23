package com.coderandyli.designpattern.practices_02.alert.alertHandle;

import com.coderandyli.designpattern.practices_02.alert.AlertRule;
import com.coderandyli.designpattern.practices_02.alert.notification.Notification;

public abstract class AlertHandle {
    protected Notification notification;
    protected AlertRule alertRule;

    public AlertHandle(Notification notification, AlertRule alertRule) {
        this.notification = notification;
        this.alertRule = alertRule;
    }


    public abstract void check(ApiStatInfo apiStatInfo);
}
