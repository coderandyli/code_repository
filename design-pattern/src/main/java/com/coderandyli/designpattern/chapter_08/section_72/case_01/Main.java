package com.coderandyli.designpattern.chapter_08.section_72.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/17 下午3:08
 */
public class Main {
    public static void main(String[] args) {
        ExpressionInterpreter interpreter = new ExpressionInterpreter();
        long result = interpreter.interpret("8 3 2 4 - + *");
        System.out.println(result);
    }
}
