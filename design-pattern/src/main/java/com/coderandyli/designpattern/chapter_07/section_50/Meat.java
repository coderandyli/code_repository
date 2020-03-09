package com.coderandyli.designpattern.chapter_07.section_50;

public class Meat extends ALunch {
    private ALunch aLunch;

    public Meat(ALunch aLunch) {
        this.aLunch = aLunch;
    }

    @Override
    public String eat() {
        return aLunch.eat() + "、meat";
    }

    @Override
    public double cost() {
        return aLunch.cost() + 8;
    }
}
