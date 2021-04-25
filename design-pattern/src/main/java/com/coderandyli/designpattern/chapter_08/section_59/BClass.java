package com.coderandyli.designpattern.chapter_08.section_59;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/20 下午2:18
 */
public class BClass {
    public void process(ICallback callback) {
        System.out.println("执行BClass#process方法....");
        callback.methodToCallback();
    }
}
