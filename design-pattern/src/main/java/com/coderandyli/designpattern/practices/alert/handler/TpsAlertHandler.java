package com.coderandyli.designpattern.practices.alert.handler;


import com.coderandyli.designpattern.practices.alert.AlertRule;
import com.coderandyli.designpattern.practices.alert.notification.Notification;

/**
 * Created by lizhen on 2019-12-14
 */
public class TpsAlertHandler extends AlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify("API request time more than threshold");
        }
    }
}
