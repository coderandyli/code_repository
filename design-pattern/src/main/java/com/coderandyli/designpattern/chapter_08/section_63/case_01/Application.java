package com.coderandyli.designpattern.chapter_08.section_63.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/30 上午11:29
 */
public class Application {

    public static void main(String[] args) {
        HandleChain handleChain = new HandleChain();
        handleChain.addHandle(new HandleA());
        handleChain.addHandle(new HandleB());

        handleChain.doHandle();
    }
}
