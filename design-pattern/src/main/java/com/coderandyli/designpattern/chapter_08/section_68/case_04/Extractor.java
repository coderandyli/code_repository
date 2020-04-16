package com.coderandyli.designpattern.chapter_08.section_68.case_04;

/**
 * 提取器
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午3:24
 */
public class Extractor implements Visitor{

    @Override
    public void visit(PDFFile file) {
        System.out.println("PDFFile extract2Txt");
    }

    @Override
    public void visit(PPTFile file) {
        System.out.println("PPTFile extract2Txt");
    }

    @Override
    public void visit(WordFile file) {
        System.out.println("WordFile extract2Txt");
    }
}
