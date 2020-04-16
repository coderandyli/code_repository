package com.coderandyli.designpattern.chapter_08.section_64.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/30 下午5:41
 *
 * d
 */
public enum Status {
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
