package com.coderandyli.inner_class.b_local_inner_class;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-05-14
 *
 * ***********  局部内部类 **********
 */
@Slf4j
public class Human {

    public Human() {
        People woman = getWoman();
    }

    public People getWoman() {
        /**
         * 1、方法中的局部内部类，作用域仅在方法体内
         */
        class Woman extends People {
            int age = 18;
            String name = "年方十八的中年老妇女";

            public Woman() {
                log.debug("age = {}, name = {}", age, name);
            }
        }
        return new Woman();
    }
}
