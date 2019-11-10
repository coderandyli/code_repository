package com.coderandyli.proxy.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-11-07
 */
@Slf4j
public class Student implements Behavior {
    @Override
    public void eat() {
        log.debug("student eat....");
    }

    @Override
    public void say(String str) {
        log.debug("student say....");
    }
}
