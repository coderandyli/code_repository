package com.coderandyli.designpattern.practices.section_62;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/5 上午9:45
 */
public abstract class Handler {
    /**
     * 后继者
     */
    private Handler successor;

    public void handle() {
        boolean handled = doHandle();
        // Ignore the business logic....
        if (!handled  && successor != null) {
            successor.handle();
        }
    }

    public abstract boolean doHandle();

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}

