package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_18_ISP.case_04;

import java.util.Map;

/**
 * Created by lizhen on 2019-12-16
 */
public class MysqlConfig implements Viewer {
    //...省略其他属性和方法...
    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}