package com.coderandyli.designpattern.practices.section_62;

/**
 * handler chain
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/5 上午9:44
 */
public class HandlerChain {
    private Handler head;
    private Handler tail;

    public void addHandler(Handler handler) {
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }

        tail.setSuccessor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
