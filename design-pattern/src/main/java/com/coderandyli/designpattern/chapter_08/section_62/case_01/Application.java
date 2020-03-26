package com.coderandyli.designpattern.chapter_08.section_62.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午1:39
 */
public class Application {
    public static void main(String[] args) {
        HandleChain handleChain = new HandleChain();
        handleChain.addHandler(new HandlerA());
        handleChain.addHandler(new HandlerB());
        handleChain.addHandler(new HandlerC());
        handleChain.handle();
    }
}
