package com.coderandyli.designpattern.chapter_08.section_62.case_03;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:12
 */
public class HandlerC implements IHandler {
    @Override
    public boolean handle() {
        boolean handle = false;
        // ignore business logic
        System.out.println("class HandlerC, method handle()");
        return handle;
    }
}
