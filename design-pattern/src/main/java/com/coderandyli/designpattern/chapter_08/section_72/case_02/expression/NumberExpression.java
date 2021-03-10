package com.coderandyli.designpattern.chapter_08.section_72.case_02.expression;

import com.coderandyli.designpattern.chapter_08.section_72.case_02.Expression;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/17 下午3:38
 */
public class NumberExpression implements Expression {

    private long number;

    public NumberExpression(long number) {
        this.number = number;
    }

    public NumberExpression(String number) {
        this.number = Long.parseLong(number);
    }

    @Override
    public long interpret() {
        return this.number;
    }
}
