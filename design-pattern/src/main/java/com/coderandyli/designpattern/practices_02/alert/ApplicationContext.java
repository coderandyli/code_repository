package com.coderandyli.designpattern.practices_02.alert;

import com.coderandyli.designpattern.practices_02.alert.alertHandle.ErrorAlertHandle;
import com.coderandyli.designpattern.practices_02.alert.alertHandle.TpsAlertHandle;
import com.coderandyli.designpattern.practices_02.alert.notification.NormalNotification;
import com.coderandyli.designpattern.practices_02.alert.notification.SevereNotification;
import com.coderandyli.designpattern.practices_02.alert.sender.EmailMsgSender;
import com.coderandyli.designpattern.practices_02.alert.sender.TelephoneMsgSender;

import java.util.Collections;

public class ApplicationContext {
    private Alert alert;
    private static final ApplicationContext instance = new ApplicationContext(); // 单例 - 饿汉模式

    public ApplicationContext() {
        initializeBeans();
    }

    private void initializeBeans() {
        TelephoneMsgSender telephoneMsgSender = new TelephoneMsgSender(Collections.singletonList("110120"));
        EmailMsgSender emailMsgSender = new EmailMsgSender(Collections.singletonList("110@163.com"));

        SevereNotification severeNotification = new SevereNotification(telephoneMsgSender);
        NormalNotification normalNotification = new NormalNotification(emailMsgSender);

        AlertRule alertRule = new AlertRule();
        TpsAlertHandle tpsAlertHandle = new TpsAlertHandle(normalNotification, alertRule);
        ErrorAlertHandle errorAlertHandle = new ErrorAlertHandle(severeNotification, alertRule);

        alert = new Alert();
        alert.addAlertHandles(tpsAlertHandle);
        alert.addAlertHandles(errorAlertHandle);
    }

    public Alert getAlert() {
        return alert;
    }

    public static ApplicationContext getInstance() {
        return instance;
    }
}
