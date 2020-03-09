package com.coderandyli.designpattern.chapter_07.section_50;

public class Vegetables extends ALunch{
    private ALunch aLunch;

    public Vegetables(ALunch aLunch) {
        this.aLunch = aLunch;
    }

    @Override
    public String eat() {
        return aLunch.eat() + "、vegatables";
    }

    @Override
    public double cost() {
        return aLunch.cost() + 5;
    }
}
