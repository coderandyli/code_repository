package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.case_03.handle;

import com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture.AlertRule;
import com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture.Notification;
import com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture.NotificationEmergencyLevel;

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
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }
}
