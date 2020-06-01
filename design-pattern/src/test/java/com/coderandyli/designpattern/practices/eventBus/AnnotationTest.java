package com.coderandyli.designpattern.practices.eventBus;

import com.coderandyli.designpattern.practices.eventBus.case_01.Subscribe;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/17 上午10:41
 */
public class AnnotationTest {

    @Subscribe
    public void exec(String userId) {
        System.out.println(userId);
    }
}
