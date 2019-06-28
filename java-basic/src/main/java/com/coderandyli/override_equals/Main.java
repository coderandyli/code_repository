package com.coderandyli.override_equals;

import java.util.HashMap;

/**
 * Created by lizhen on 2019-05-19
 *
 * https://www.cnblogs.com/dengyungao/p/7525135.html
 */
public class Main {

    public static void main(String args[]) {
        User user = new User("Andy",18);

        HashMap<User, String> map = new HashMap<>();
        map.put(user, "handsome");

        /**
         * 自定义类作为HashMap的key值时，必须重新equals和hashCode方法
         *
         * 1、如果只重写了equals方法而没有重洗hashCode方法，下面输出的是 null 而不是 handsome
         *      1.1 因为 new User("Andy",18) 与 new User("Andy",18)  实际是生成的是两个对象，他们的存储地址是不同的。
         *      如果重写hashCode方法，默认情况下 hash值与对象的存储地址有关（不能笼统的说成 hashCode默认情况下
         *      返回的是对象的存储地址）；
         *      1.2 HashMap的key的hash值是在key值的hashCode的基础上计算的
         *
         *      所以必须重写 hashCode方法
         */
        System.out.println(map.get(new User("Andy",18)));


    }
}
