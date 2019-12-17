package com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.case_03.handle;

import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.fixture.AlertRule;
import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.fixture.Notification;
import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.fixture.NotificationEmergencyLevel;

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
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
