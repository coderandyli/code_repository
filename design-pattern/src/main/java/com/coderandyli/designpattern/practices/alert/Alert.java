package com.coderandyli.designpattern.practices.alert;


import com.coderandyli.designpattern.practices.alert.handler.AlertHandler;
import com.coderandyli.designpattern.practices.alert.handler.ApiStatInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 警告类
 */
public class Alert {
    private List<AlertHandler> alertHandlers = new ArrayList<>();

    void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }


//    // 改动一：添加参数timeoutCount
//    public void check(String api, long requestCount, long errorCount, long timeoutCount, long durationOfSeconds) {
//        long tps = requestCount / durationOfSeconds;
//        if (tps > rule.getMatchedRule(api).getMaxTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }
//        if (errorCount > rule.getMatchedRule(api).getMaxErrorCount()) {
//            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
//        }
//        // 改动二：添加接口超时处理逻辑
//        long timeoutTps = timeoutCount / durationOfSeconds;
//        if (timeoutTps > rule.getMatchedRule(api).getMaxTimeoutTps()) {
//            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
//        }
//    }
}
