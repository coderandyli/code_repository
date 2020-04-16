package com.coderandyli.designpattern.chapter_08.section_68.case_04;

/**
 * 压缩器 文件压缩
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午4:05
 */
public class Compressor implements Visitor{

    @Override
    public void visit(PDFFile file) {
        System.out.println("PDFFile compress");
    }

    @Override
    public void visit(PPTFile file) {
        System.out.println("PPTFile compress");
    }

    @Override
    public void visit(WordFile file) {
        System.out.println("WordFile compress");
    }
}
