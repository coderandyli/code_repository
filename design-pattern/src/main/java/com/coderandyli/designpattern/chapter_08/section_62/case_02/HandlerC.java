package com.coderandyli.designpattern.chapter_08.section_62.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午1:30
 */
public class HandlerC extends Handler {

    @Override
    public boolean doHandle() {
        boolean handled = false;
        // ignore business logic....
        System.out.println("class HandlerB; method handle()");
        return false;
    }
}
