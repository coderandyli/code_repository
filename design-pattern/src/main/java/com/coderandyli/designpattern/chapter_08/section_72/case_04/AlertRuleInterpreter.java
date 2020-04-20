package com.coderandyli.designpattern.chapter_08.section_72.case_04;

import java.util.Map;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 上午11:51
 */
public class AlertRuleInterpreter {
    private Expression expression;

    public AlertRuleInterpreter(String ruleExpression) {
        this.expression = new OrExpression(ruleExpression);
    }

    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }


}
