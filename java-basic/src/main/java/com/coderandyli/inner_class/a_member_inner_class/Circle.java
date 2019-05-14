package com.coderandyli.inner_class.a_member_inner_class;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by lizhen on 2019-05-14
 *
 * ****************** 成员内部类 ******************
 *
 * 1、成员内部类可以无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
 *
 * 2、内部类与外部类的成员变量或方法重复时，访问方式如下
 *     - 外部类.this.成员变量
 *     - 外部类.this.成员方法
 *
 * 3、外部类访问内部类的成员时，必须创建一个成员内部类的对象，再通过指向这个对象的引用来访问
 *
 */
@Slf4j
public class Circle {
    private double radius = 0;
    public static String name = "我是外部类";
    public int count = 1;

    public Circle(double radius) {
        this.radius = radius;
        getDrawInstance().drawSahpe();   //必须先创建成员内部类的对象，再进行访问
    }

    public Draw getDrawInstance() {
        return new Draw();
    }

    /**
     * 内部类
     */
    class Draw {
        public String name = "我是内部类";

        public void drawSahpe() {
            log.debug("外部类的private成员radius = {}", radius);
            log.debug("外部类的成员变量 count = {}", Circle.this.count);

            /**
             * 2、内部类与外部类的成员变量或方法重复时，访问方式
             *    外部类.this.成员变量
             *    外部类.this.成员方法
             */
            log.debug("外部类的静态成员变量 name = {}", Circle.this.name);
            log.debug("内部类的成员变量 name = {}", name);

        }
    }
}
