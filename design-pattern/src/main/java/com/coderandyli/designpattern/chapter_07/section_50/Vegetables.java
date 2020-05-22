package com.coderandyli.designpattern.chapter_07.section_50;

public class Vegetables extends AbstractLunch {
    private AbstractLunch abstractLunch;

    public Vegetables(AbstractLunch abstractLunch) {
        this.abstractLunch = abstractLunch;
    }

    @Override
    public String eat() {
        return abstractLunch.eat() + "、vegatables";
    }

    @Override
    public double cost() {
        return abstractLunch.cost() + 5;
    }
}
