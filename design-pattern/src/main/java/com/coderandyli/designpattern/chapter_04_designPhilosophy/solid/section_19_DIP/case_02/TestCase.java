package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_19_DIP.case_02;

/**
 * Created by lizhen on 2019-12-17
 */
public abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("TestSubscriber succeed.");
        } else {
            System.out.println("TestSubscriber failed.");
        }
    }

    public abstract boolean doTest();
}