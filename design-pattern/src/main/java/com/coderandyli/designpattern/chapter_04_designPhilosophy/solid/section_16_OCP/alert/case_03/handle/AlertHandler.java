package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.case_03.handle;

import com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture.AlertRule;
import com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.fixture.Notification;

/**
 * Created by lizhen on 2019-12-14
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
