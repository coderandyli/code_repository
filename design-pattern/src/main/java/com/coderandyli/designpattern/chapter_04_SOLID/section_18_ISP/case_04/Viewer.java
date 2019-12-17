package com.coderandyli.designpattern.chapter_04_SOLID.section_18_ISP.case_04;

import java.util.Map;

/**
 * Created by lizhen on 2019-12-16
 */
public interface Viewer {
    String outputInPlainText();
    Map<String, String> output();
}
