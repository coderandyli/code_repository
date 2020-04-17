package com.coderandyli.designpattern.chapter_08.section_70.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午6:10
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    /**
     * 拼接
     * @param input
     */
    public void append(String input) {
        text.append(input);
    }

    /**
     * 创建快照
     * @return
     */
    public Snapshot createSnapshot() {
        return new Snapshot(getText());
    }

    /**
     * 撤销 恢复到上一版本
     * @param snapshot
     */
    public void restoreSnapshot(Snapshot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }
}
