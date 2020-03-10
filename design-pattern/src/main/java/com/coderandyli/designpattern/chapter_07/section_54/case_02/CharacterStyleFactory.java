package com.coderandyli.designpattern.chapter_07.section_54.case_02;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 字体样式设计 工厂类
 */
public class CharacterStyleFactory {
    private static final List<CharacterStyle> styles = new ArrayList<>();

    public static CharacterStyle getStyle(Font font, int size, int colorRGB) {
        CharacterStyle newStyle = new CharacterStyle(font, size, colorRGB);
        for (CharacterStyle style : styles) {
            if (style.equals(newStyle)) {
                return style;
            }
        }
        styles.add(newStyle);
        return newStyle;
    }
}
