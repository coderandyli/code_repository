package com.coderandyli.designpattern.chapter_08.section_72.case_04;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * " || " 表达式解释器
 *
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 上午10:34
 */
public class OrExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String strOrExpression) {
        String[] andExpressions = strOrExpression.split("\\|\\|");
        for (String andExpr : andExpressions) {
            expressions.add(new AddExpression(andExpr));
        }
    }

    public OrExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expr : expressions) {
            if (expr.interpret(stats)) {
                return true;
            }
        }
        return false;
    }
}
