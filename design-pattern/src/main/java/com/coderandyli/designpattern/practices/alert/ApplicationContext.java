package com.coderandyli.designpattern.practices.alert;

import com.coderandyli.designpattern.practices.alert.handler.ErrorAlertHandler;
import com.coderandyli.designpattern.practices.alert.handler.TpsAlertHandler;
import com.coderandyli.designpattern.practices.alert.msgSender.EmailMsgSender;
import com.coderandyli.designpattern.practices.alert.msgSender.MsgSender;
import com.coderandyli.designpattern.practices.alert.msgSender.TelephoneMsgSender;
import com.coderandyli.designpattern.practices.alert.notification.NormalNotification;
import com.coderandyli.designpattern.practices.alert.notification.Notification;
import com.coderandyli.designpattern.practices.alert.notification.SevereNotification;

import java.util.Collections;

/**
 * Created by lizhen on 2019-12-14
 * ApplicationContext 是一个单例类，负责 Alert 的创建、组装（alertRule 和 notification 的依赖注入）、初始化（添加 handlers）工作。
 */
public class ApplicationContext {
    private AlertRule alertRule;
    // private Notification notification;
    private Alert alert;

    public void initializeBeans() {
        alertRule = new AlertRule(/*.省略参数.*/); //省略一些初始化代码
        MsgSender telephoneMsgSender = new TelephoneMsgSender(Collections.singletonList("13052057357"));
        MsgSender emailMsgSender = new EmailMsgSender(Collections.singletonList("coderandyli@163.com"));

        Notification severeNotification = new SevereNotification(telephoneMsgSender);
        Notification normalNotification = new NormalNotification(emailMsgSender);


        alert = new Alert();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, normalNotification));
        alert.addAlertHandler(new ErrorAlertHandler(alertRule, severeNotification));
    }

    public Alert getAlert() {
        return alert;
    }

    // 饿汉式单例
    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }
}

