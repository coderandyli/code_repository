package com.coderandyli.designpattern.chapter_08.section_68.case_04;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/15 下午4:13
 */
public abstract class ResourceFile {
    private String filePath;

    public ResourceFile(String filePath) {
        this.filePath = filePath;
    }

    public abstract void accept(Visitor visitor);
}
