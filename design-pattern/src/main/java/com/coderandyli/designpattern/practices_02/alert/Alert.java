package com.coderandyli.designpattern.practices_02.alert;

import com.coderandyli.designpattern.practices_02.alert.alertHandle.AlertHandle;
import com.coderandyli.designpattern.practices_02.alert.alertHandle.ApiStatInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 接口警告类
 */
public class Alert {
    private List<AlertHandle> alertHandles = new ArrayList<>();

    public void addAlertHandles(AlertHandle alertHandle) {
        alertHandles.add(alertHandle);
    }

    /**
     * check api info
     */
    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandle alertHandle : alertHandles) {
            alertHandle.check(apiStatInfo);
        }
    }

}
