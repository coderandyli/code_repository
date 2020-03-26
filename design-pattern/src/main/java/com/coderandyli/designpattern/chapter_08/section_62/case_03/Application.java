package com.coderandyli.designpattern.chapter_08.section_62.case_03;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:19
 */
public class Application {
    public static void main(String[] args) {
        HandleChain handleChain = new HandleChain();
        handleChain.addHandle(new HandlerA());
        handleChain.addHandle(new HandlerB());
        handleChain.addHandle(new HandlerC());
        handleChain.handle();
    }
}
