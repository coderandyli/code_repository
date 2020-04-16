package com.coderandyli.designpattern.chapter_08.section_68.case_01;

import com.coderandyli.designpattern.chapter_08.section_67.case_01.ArrayList;
import com.coderandyli.designpattern.chapter_08.section_67.case_01.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/15 下午4:38
 */
public class Application {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = getAllResourceFiles();

        for (int i = 0; i <resourceFiles.size() ; i++) {
            ResourceFile file = resourceFiles.get(i);
            file.extract2Txt();
        }
    }

    public static List<ResourceFile> getAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PDFFile("pdf.file"));
        resourceFiles.add(new PPTFile("ppt.file"));
        resourceFiles.add(new WordFile("word.file"));
        return resourceFiles;
    }
}
