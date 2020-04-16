package com.coderandyli.designpattern.chapter_08.section_68.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/15 下午4:33
 */
public class WordFile extends ResourceFile{
    public WordFile(String filePath) {
        super(filePath);
    }

    @Override
    public void extract2Txt() {
        // ignore business logic
        System.out.println("WordFile extract2Txt");
    }
}
