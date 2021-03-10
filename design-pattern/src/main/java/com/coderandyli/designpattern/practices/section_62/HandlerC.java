package com.coderandyli.designpattern.practices.section_62;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/6/5 上午10:08
 */
public class HandlerC extends Handler {

    @Override
    public boolean doHandle() {
        System.out.println("exec HandlerC#doHandle");
        return false;
    }
}
