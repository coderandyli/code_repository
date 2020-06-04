package com.coderandyli.designpattern.practices.section_59;

/**
 * 回调函数
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/3 上午9:14
 */
public class AClass {

    public static void main(String[] args) {

        // inner class
        new BClass().process(new ICallback() {
            @Override
            public void methodToCallBack() {
                System.out.println("Executing methodToCallBack() method");
            }
        });

        // lamada
        new BClass().process(() -> System.out.println("Executing methodToCallBack() method"));
    }
}
