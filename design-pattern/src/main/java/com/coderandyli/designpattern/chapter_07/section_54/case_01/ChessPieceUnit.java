package com.coderandyli.designpattern.chapter_07.section_54.case_01;

/**
 * 抽取象棋类的共有属性
 */
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color {
        RED, BLACK
    }
}
