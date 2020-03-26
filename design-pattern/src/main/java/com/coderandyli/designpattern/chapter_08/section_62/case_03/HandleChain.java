package com.coderandyli.designpattern.chapter_08.section_62.case_03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/26 下午2:14
 */
public class HandleChain {
    private List<IHandler> handlers = new ArrayList<>();

    public void addHandle(IHandler handler) {
        handlers.add(handler);
    }

    public void handle() {
        for (IHandler handler : handlers) {
            boolean handled = handler.handle();
            if (handled){
                break;
            }
        }
    }

}
