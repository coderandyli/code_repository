package com.coderandyli.designpattern.practices.section_59;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/3 上午9:15
 */
public class BClass {

    public void process(ICallback callback) {
        System.out.println("Ignore the business logic before the callback");
        callback.methodToCallBack();
        System.out.println("Ignore the business logic after the callback");
    }
}
