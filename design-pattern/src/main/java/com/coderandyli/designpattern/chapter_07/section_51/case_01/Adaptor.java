package com.coderandyli.designpattern.chapter_07.section_51.case_01;

public class Adaptor extends Adaptee implements ITarget {
    @Override
    public void f1() {
        //改造中逻辑
        super.fa();
        //改造中逻辑

    }

    @Override
    public void f2() {
        //改造中逻辑
        super.fa();
        //改造中逻辑
    }

    @Override
    public void f3() {
        //改造中逻辑
        super.fa();
        //改造中逻辑
    }
}
