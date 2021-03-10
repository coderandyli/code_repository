package com.coderandyli.designpattern.chapter_08.section_62.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午1:30
 */
public class HandlerB extends Handler {

    @Override
    public boolean handle() {
        boolean handled = false;
        // ignore business logic....
        System.out.println("class HandlerB; method handler()");
        if (!handled && succesor != null){
            succesor.handle();
        }

        return false;
    }
}
