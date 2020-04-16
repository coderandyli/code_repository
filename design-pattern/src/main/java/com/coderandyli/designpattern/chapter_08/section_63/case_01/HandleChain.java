package com.coderandyli.designpattern.chapter_08.section_63.case_01;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/30 上午11:11
 */
@Slf4j
public class HandleChain {
    // 当前执行到的handle
    private int pos = 0;
    // handle 数量
    private int n = 10;
    private ArrayList<Handle> handles = new ArrayList<>();


    public void doHandle() {
        if (pos < handles.size()) {
            log.info("第 {} 个handle, doHandle()执行前", pos);
            Handle handle = handles.get(pos++);
            handle.doHandle(this);
            log.info("第 {} 个handle, doHandle()执行后", pos-1);
        }
    }

    public void addHandle(Handle handle) {
        if (handle == null) {
            return;
        }
        handles.add(handle);
    }
}
