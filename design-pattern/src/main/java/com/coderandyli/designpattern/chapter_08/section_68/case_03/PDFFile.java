package com.coderandyli.designpattern.chapter_08.section_68.case_03;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/15 下午4:15
 */
public class PDFFile extends ResourceFile {
    public PDFFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor extractor) {
        extractor.extract2Txt(this);
    }

    @Override
    public void accept(Compressor compressor) {
        compressor.compress(this);
    }
}
