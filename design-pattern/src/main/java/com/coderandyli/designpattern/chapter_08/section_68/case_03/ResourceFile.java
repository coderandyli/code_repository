package com.coderandyli.designpattern.chapter_08.section_68.case_03;

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

    public abstract void  accept(Extractor extractor);

    public abstract void accept(Compressor compressor);
}
