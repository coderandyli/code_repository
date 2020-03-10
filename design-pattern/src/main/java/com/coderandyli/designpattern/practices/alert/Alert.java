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

    public void addAlertHandler(AlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {

        for (AlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}
