package com.coderandyli.jvm.chapter12.section03;

/**
 * Created by lizhen on 2019-11-20
 * volatile使用场景
 * volatile适合做状态标识量
 */
public class VolatileCase {

    private volatile boolean initialized = false;

    public void init(){
        // ... 耗时操作 ...
        initialized = true;
    }

    public void doWork(){
        while (initialized){
            // do something
        }
    }

}
