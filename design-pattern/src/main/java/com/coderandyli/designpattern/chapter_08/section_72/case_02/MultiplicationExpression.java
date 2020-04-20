package com.coderandyli.designpattern.chapter_08.section_72.case_02;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/17 下午4:40
 */
public class MultiplicationExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    public MultiplicationExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public long interpret() {
        return expr1.interpret() * expr2.interpret();
    }
}
