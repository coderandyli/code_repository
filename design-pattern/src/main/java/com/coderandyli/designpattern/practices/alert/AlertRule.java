package com.coderandyli.designpattern.practices.alert;

/**
 * 警告规则
 */
public class AlertRule {
    public AlertRule getMatchedRule(String api) {
        return new AlertRule();
    }

    public long getMaxTps() {
        return 5;
    }

    public long getMaxErrorCount() {
        return 100;
    }

    public long getMaxTimeoutTps() {
        return 10;
    }
}
