package com.coderandyli.designpattern.chapter_08.section_72.case_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * " && "表达式解释器
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 上午10:31
 */
public class AddExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();

    public AddExpression(String expression) {
        String[] strExpressions = expression.trim().split("&&");
        for (String strExp : strExpressions) {
            if (strExp.contains("<")){
                 expressions.add(new LessExpression(strExp));
            }else if (strExp.contains(">")) {
                expressions.add(new GrreaterExpression(strExp));
            }else if (strExp.contains("==")){
                expressions.add(new AddExpression(strExp));
            }
        }
    }

    public AddExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expr : expressions) {
            if (!expr.interpret(stats)){
                return false;
            }
        }
        return true;
    }


}
