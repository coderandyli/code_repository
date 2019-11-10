package com.coderandyli.proxy.staticProxy;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-11-07
 *
 * 代理对象对，原有对象代码增强
 */
@Slf4j
public class StudentProxy implements Behavior {
    private Student behavior;

    public StudentProxy(Student behavior) {
        this.behavior = behavior;
    }

    @Override
    public void eat() {
        log.debug("proxy eat before");
        behavior.eat();
        log.debug("proxy eat after");
    }

    @Override
    public void say(String str) {
        log.debug("proxy say before");
        behavior.say(str);
        log.debug("proxy say after");
    }
}
