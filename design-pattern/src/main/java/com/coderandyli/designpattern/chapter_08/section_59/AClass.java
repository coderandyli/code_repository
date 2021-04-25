package com.coderandyli.designpattern.chapter_08.section_59;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/20 下午2:21
 */
public class AClass {
    public static void main(String[] args) {
        BClass bClass = new BClass();
        bClass.process(new ICallback() {
            @Override
            public void methodToCallback() {
                System.out.println("执行完成之后回调");
            }
        });
    }
}
