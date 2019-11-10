package com.coderandyli.jvm.chapter10.section03;

/**
 * Created by lizhen on 2019-11-10
 *
 */
public class CompileTest {

    /**
     * 进行条件编译：使用条件为常量的if语句
     *  只会编译block 1 代码
     * @param args
     */
    public static void main(String args[]) {

        if (true) {
            System.out.println("block 1");
        } else {
            System.out.println("block 2");
        }
    }
}
