package com.coderandyli.designpattern.chapter_08.section_62.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午1:28
 *
 *  a abstract class of Handler
 */
public abstract class Handler {
    Handler successor = null;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handle(){
        boolean handled = doHandle();
        if (!handled && successor != null){
            successor.handle();
        }
    }

    public abstract boolean doHandle();
}
