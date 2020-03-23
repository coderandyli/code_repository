package com.coderandyli.designpattern.chapter_08.section_60.case_01;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/20 下午4:14
 */
public class Main {

    public static void main(String[] args) {
        StrategyFactory strategyFactory = new StrategyFactory();
        Strategy strategy = strategyFactory.getStrategy("one");
        strategy.algorithmInterface();
    }
}
