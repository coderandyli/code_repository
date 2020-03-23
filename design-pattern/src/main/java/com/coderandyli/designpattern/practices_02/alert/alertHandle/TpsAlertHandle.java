package com.coderandyli.designpattern.practices_02.alert.alertHandle;

import com.coderandyli.designpattern.practices_02.alert.AlertRule;
import com.coderandyli.designpattern.practices_02.alert.notification.Notification;

public class TpsAlertHandle extends AlertHandle{


    public TpsAlertHandle(Notification notification, AlertRule alertRule) {
        super(notification, alertRule);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        // Ignore judgment logic ...
        notification.notify("api timeout count more than threshold");
    }
}
