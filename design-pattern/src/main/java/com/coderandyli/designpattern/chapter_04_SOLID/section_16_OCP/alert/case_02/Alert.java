package com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.case_02;

import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.fixture.AlertRule;
import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.fixture.Notification;
import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.fixture.NotificationEmergencyLevel;

/**
 * Created by lizhen on 2019-12-14
 */

public class Alert {
    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    // 改动一：添加参数timeoutCount
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds, long timeoutCount) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
        // 改动二：添加接口超时处理逻辑
        long timeoutTps = timeoutCount / durationOfSeconds;
        if (timeoutTps > rule.getMatchedRule(api).getMaxTimeoutTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }
}
