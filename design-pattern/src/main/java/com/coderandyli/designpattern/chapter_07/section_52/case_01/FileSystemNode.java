package com.coderandyli.designpattern.chapter_07.section_52.case_01;


public abstract class FileSystemNode {
    protected String path;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();
    public abstract long countSizeOfFiles();

    public String getPath() {
        return path;
    }
}


