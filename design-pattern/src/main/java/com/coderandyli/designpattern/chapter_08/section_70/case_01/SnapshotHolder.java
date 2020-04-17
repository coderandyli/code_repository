package com.coderandyli.designpattern.chapter_08.section_70.case_01;

import java.util.Stack;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午6:11
 */
public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();

    /**
     * 出
     */
    public Snapshot pop() {
        return snapshots.pop();
    }

    /**
     * 进
     */
    public void push(Snapshot snapshot) {
        snapshots.push(snapshot);
    }

}
