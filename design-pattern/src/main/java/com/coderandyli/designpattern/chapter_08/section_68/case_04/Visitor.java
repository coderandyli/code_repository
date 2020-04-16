package com.coderandyli.designpattern.chapter_08.section_68.case_04;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午4:13
 */
public interface Visitor {
    void visit(PDFFile file);
    void visit(PPTFile file);
    void visit(WordFile file);
}
