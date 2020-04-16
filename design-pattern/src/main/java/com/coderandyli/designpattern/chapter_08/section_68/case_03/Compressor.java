package com.coderandyli.designpattern.chapter_08.section_68.case_03;

/**
 * 压缩器 文件压缩
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午4:05
 */
public class Compressor {
    public void compress(PDFFile file) {
        System.out.println("PDFFile compress");
    }

    public void compress(PPTFile file) {
        System.out.println("PPTFile compress");
    }

    public void compress(WordFile file) {
        System.out.println("WordFile compress");
    }
}
