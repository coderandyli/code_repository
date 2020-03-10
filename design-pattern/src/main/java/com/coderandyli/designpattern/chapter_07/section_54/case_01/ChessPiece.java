package com.coderandyli.designpattern.chapter_07.section_54.case_01;

/**
 * 象棋类
 */
public class ChessPiece {
    private ChessPieceUnit chessPieceUnit;
    private int positionX;
    private int positionY;

    public ChessPiece(ChessPieceUnit unit, int positionX, int positionY) {
        this.chessPieceUnit = unit;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    // 省略getter、setter方法
}
