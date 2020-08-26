package com.coderandyli.common;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/8/26 下午6:01
 */
public class Main {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        /**
         * i++ 与 ++i
         * 独立使用时，没有区别，都相当于 i = i + 1
         *
         * 在语句中使用时，i++ 先赋值，再+1; ++i 先+1，再赋值;
         */
        // i++
        System.out.println(i++);
        System.out.println(i);

        // ++i
        System.out.println(++j);
        System.out.println(j);
    }
}
