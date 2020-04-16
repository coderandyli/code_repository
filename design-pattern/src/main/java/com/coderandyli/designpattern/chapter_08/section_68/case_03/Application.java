package com.coderandyli.designpattern.chapter_08.section_68.case_03;


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
        Compressor compressor = new Compressor();
        for (int i = 0; i < resourceFiles.size(); i++) {
            ResourceFile file = resourceFiles.get(i);
            file.accept(extractor);
            file.accept(compressor);
        }
    }

    private static List<ResourceFile> getAllResourceFiles() {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PDFFile("pdf.file"));
        resourceFiles.add(new PPTFile("ppt.file"));
        resourceFiles.add(new WordFile("word.file"));
        return resourceFiles;
    }
}
