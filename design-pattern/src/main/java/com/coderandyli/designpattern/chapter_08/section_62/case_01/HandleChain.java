package com.coderandyli.designpattern.chapter_08.section_62.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午1:34
 *
 * handler chain
 */
public class HandleChain {
    private Handler head = null;
    private Handler tail = null;
    
    public void addHandler(Handler handler) {
        handler.setSuccesor(null);
        if (head == null){
            head = handler;
            tail = handler;
            return;
        }
        tail.setSuccesor(handler);
        tail = handler;
    }

    public void handle() {
        if (head != null){
            head.handle();
        }
    }
}
