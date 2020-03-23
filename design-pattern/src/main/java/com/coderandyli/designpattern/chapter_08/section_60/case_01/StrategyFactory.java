package com.coderandyli.designpattern.chapter_08.section_60.case_01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/3/20 下午4:10
 */
public class StrategyFactory {
    private static final Map<String, Strategy> strategies = new HashMap<>();

    static {
        strategies.put("one", new ConcreteStrategyOne());
        strategies.put("two", new ConcreteStrategyTwo());
    }

    public Strategy getStrategy(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return strategies.get(type);
    }
}
