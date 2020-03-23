package com.coderandyli.designpattern.chapter_08.section_60.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/20 下午4:07
 */
public class ConcreteStrategyOne implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("class: ConcreteStrategyOne; method: algorithmInterface");
    }
}
