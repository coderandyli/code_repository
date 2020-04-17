package com.coderandyli.designpattern.chapter_08.section_70.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午6:11
 */
public class Snapshot {
    public String getText() {
        return text;
    }

    private String text;

    public Snapshot(String text) {
        this.text = text;
    }
}
