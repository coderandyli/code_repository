package com.coderandyli.designpattern.chapter_08.section_57.case_02;

public class TestSubscriber {

    @Subscribe
    public void exec(Main main) {
        System.out.println("执行中");
    }
}
