package com.coderandyli.proxy;

import com.coderandyli.proxy.Behavior;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-11-07
 */
@Slf4j
public class Student implements Behavior {
    @Override
    public void eat() {
        System.out.println("student eat....");
    }

    @Override
    public void say(String str) {
        System.out.println("student say....");
    }
}
