package com.coderandyli.designpattern.practices_02.alert;

public class AlertRule {
    
    public int getMaxErrorCount() {
        return 5;
    }

    public int getMaxTps() {
        return 5;
    }

    public int getMaxTimeout() {
        return 10;
    }
}
