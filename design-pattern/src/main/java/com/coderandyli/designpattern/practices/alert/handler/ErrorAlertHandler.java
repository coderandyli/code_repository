package com.coderandyli.designpattern.practices.alert.handler;


import com.coderandyli.designpattern.practices.alert.AlertRule;
import com.coderandyli.designpattern.practices.alert.notification.Notification;

/**
 * Created by lizhen on 2019-12-14
 */

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            notification.notify("API error count more than threshold");
        }
    }
}
