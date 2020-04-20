package com.coderandyli.designpattern.chapter_08.section_72.case_03;

import java.util.Map;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 上午10:03
 */
public class AlertRuleInterpreter {
    private String ruleExpression;

    public AlertRuleInterpreter(String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

    public boolean interpret(Map<String, Long> stats) {
        //todo 待完善
        return false;
    }
}
