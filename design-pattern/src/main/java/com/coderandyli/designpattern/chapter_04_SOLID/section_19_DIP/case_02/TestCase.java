package com.coderandyli.designpattern.chapter_04_SOLID.section_19_DIP.case_02;

/**
 * Created by lizhen on 2019-12-17
 */
public abstract class TestCase {
    public void run() {
        if (doTest()) {
            System.out.println("Test succeed.");
        } else {
            System.out.println("Test failed.");
        }
    }

    public abstract boolean doTest();
}