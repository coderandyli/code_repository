package com.coderandyli.designpattern.chapter_08.section_72.case_04;

import java.util.Map;

/**
 * " > " 表达式解释器
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 上午10:27
 */
public class GrreaterExpression implements Expression {
    private String key;
    private Long value;

    public GrreaterExpression(String expression) {
        String[] elements = expression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].trim().equals(">")){
            throw new RuntimeException("Expression is invalid: "+ expression);
        }

        this.key = elements[0].trim();
        this.value = Long.parseLong(elements[2]);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(key) ){
            return false;
        }
        return stats.get(key) > value;
    }
}
