package com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.case_03;

import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.case_03.handle.AlertHandler;
import com.coderandyli.designpattern.chapter_04_SOLID.section_16_OCP.alert.case_03.handle.ApiStatInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-12-14
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




