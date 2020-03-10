package com.coderandyli.designpattern.chapter_07.section_49.case_01;

import java.util.List;

/**
 * 通知类
 */
public class Notification {
    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setWechatIds(List<String> wechatIds) {
        this.wechatIds = wechatIds;
    }

    public void notify(NotificationEmergencyLevel level, String message) {
        switch (level) {
            case SEVERE:
                // ... 自动语音电话通知 ...
                break;
            case URGENCY:
                // ... 微信通知 ...
                break;
            case NORMAL:
                // ... 邮件通知 ...
                break;
            case TRIVIAL:
                // ... 邮件通知 ...
                break;
            default:
                break;
        }

    }
}
