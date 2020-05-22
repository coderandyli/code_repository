package com.coderandyli.designpattern.chapter_07.section_50;

public class Lunch extends AbstractLunch {

    @Override
    public String eat() {
        return "the lunch has rice";
    }

    @Override
    public double cost() {
        return 2d;
    }
}
