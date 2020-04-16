package com.coderandyli.designpattern.chapter_08.section_68.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/16 下午3:24
 */
public class Extractor {

    public void extract2Txt(PDFFile file) {
        System.out.println("PDFFile extract2Txt");
    }

    public void extract2Txt(PPTFile file) {
        System.out.println("PPTFile extract2Txt");
    }

    public void extract2Txt(WordFile file) {
        System.out.println("WordFile extract2Txt");
    }

}
