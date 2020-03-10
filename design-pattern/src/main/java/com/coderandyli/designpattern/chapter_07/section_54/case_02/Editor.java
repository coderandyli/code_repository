package com.coderandyli.designpattern.chapter_07.section_54.case_02;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Character> chars = new ArrayList<Character>();

    public void appendCharacter(char c, Font font, int size, int colorRGB) {
        Character character = new Character(c, CharacterStyleFactory.getStyle(font, size, colorRGB));
    }
}