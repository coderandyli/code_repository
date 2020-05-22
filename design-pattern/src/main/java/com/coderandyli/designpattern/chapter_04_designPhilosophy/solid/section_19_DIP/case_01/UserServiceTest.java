package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_19_DIP.case_01;

/**
 * Created by lizhen on 2019-12-17
 */

public class UserServiceTest {
    public static boolean doTest() {
        // ...
        return true;
    }

    public static void main(String[] args) {//这部分逻辑可以放到框架中
        if (doTest()) {
            System.out.println("TestSubscriber succeed.");
        } else {
            System.out.println("TestSubscriber failed.");
        }
    }
}
