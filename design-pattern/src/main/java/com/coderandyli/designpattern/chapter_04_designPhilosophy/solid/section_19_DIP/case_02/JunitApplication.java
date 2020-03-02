package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_19_DIP.case_02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-12-17
 */
public class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();

    public static void register(TestCase testCase) {
        testCases.add(testCase);
    }

    public static final void main(String[] args) {
        for (TestCase testCase : testCases) {
            testCase.run();
        }
    }
}
