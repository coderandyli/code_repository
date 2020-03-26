package com.coderandyli.designpattern.chapter_08.section_62.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午1:28
 *
 *  a abstract class of Handler
 */
public abstract class Handler {
    Handler succesor = null;

    public void setSuccesor(Handler succesor) {
        this.succesor = succesor;
    }

    public void handle(){
        boolean handled = doHandle();
        if (!handled && succesor != null){
            succesor.handle();
        }
    };

    public abstract boolean doHandle();
}
