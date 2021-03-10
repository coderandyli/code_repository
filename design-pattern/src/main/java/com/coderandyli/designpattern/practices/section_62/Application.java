package com.coderandyli.designpattern.practices.section_62;

/**
 * HandlerA、HandlerB、HandlerC三个处理器，顺序处理，当某个处理器能够处理时，终止处理
 *
 * 职责链模式练习
 *  - 实现方式：链表(head 和 tail) + 模板模式
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/5 上午9:40
 */
public class Application {

    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.addHandler(new HandlerC());

        handlerChain.handle();
    }
}
