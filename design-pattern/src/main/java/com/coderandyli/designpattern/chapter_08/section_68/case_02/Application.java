package com.coderandyli.designpattern.chapter_08.section_68.case_02;


import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/15 下午4:38
 */
public class Application {

    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = getAllResourceFiles();

        Extractor extractor = new Extractor();

        for (int i = 0; i <resourceFiles.size() ; i++) {
            ResourceFile file = resourceFiles.get(i);
            /**
             * 以下会报错，java只支持单分派，重载方法静态绑定
             */
            // extractor.extract2Txt(file);
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
