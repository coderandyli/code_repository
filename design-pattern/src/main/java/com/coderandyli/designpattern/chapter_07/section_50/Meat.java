package com.coderandyli.designpattern.chapter_07.section_50;

public class Meat extends AbstractLunch {
    private AbstractLunch abstractLunch;

    public Meat(AbstractLunch abstractLunch) {
        this.abstractLunch = abstractLunch;
    }

    @Override
    public String eat() {
        return abstractLunch.eat() + "、meat";
    }

    @Override
    public double cost() {
        return abstractLunch.cost() + 8;
    }
}
