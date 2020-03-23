package com.coderandyli.designpattern.practices_02.alert.alertHandle;

import com.coderandyli.designpattern.practices_02.alert.AlertRule;
import com.coderandyli.designpattern.practices_02.alert.notification.Notification;

public class ErrorAlertHandle extends AlertHandle{

    public ErrorAlertHandle(Notification notification, AlertRule alertRule) {
        super(notification, alertRule);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        // Ignore judgment logic ...
        System.out.println("error count more than threshold");
    }
}
