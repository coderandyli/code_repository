package com.coderandyli.designpattern.chapter_07.section_51.case_02;

public class Adaptor implements ITarget {
    private Adaptee adaptee;

    public Adaptor(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void f1() {
        //改造中逻辑
        this.adaptee.fa();
        //改造中逻辑
    }

    @Override
    public void f2() {
        //改造中逻辑
        this.adaptee.fa();
        //改造中逻辑
    }

    @Override
    public void f3() {
        //改造中逻辑
        this.adaptee.fa();
        //改造中逻辑
    }
}
