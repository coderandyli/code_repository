package com.coderandyli.enums;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-08-22
 */
@Slf4j
public class Main {
    public static void main(String args[]) {

        WeekEnum tue = WeekEnum.TUE; // 星期二

        /**
         * 遍历枚举
         */
        for (WeekEnum value : WeekEnum.values()) {
            log.info("WeekEnum foreach: {}", value);
        }

        log.info("---------------- splitLine ----------------");

        log.info("TUE 在枚举中的序号：{}", tue.ordinal());

        log.info("{}", tue.name());

        log.info("---------------- splitLine ----------------");

        // switch
        switch (tue) {
            case MON:
                log.info("周一");
                break;
            case TUE:
                log.info("周二");
                break;
            case WED:
                log.info("周三");
                break;
            case THU:
                log.info("周四");
                break;
            case FRI:
                log.info("周五");
                break;
            case SAT:
                log.info("周六");
                break;
            case SUN:
                log.info("周七");
                break;
            default:
                break;
        }
//
//        //
//        int i = custom.compareTo(TypeEnum.custom);
    }
}
