package com.coderandyli.designpattern.chapter_08.section_72.case_04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 下午2:17
 */
public class Application {
    public static void main(String[] args) {
        Map<String, Long> apiStat = new HashMap<>();
        apiStat.put("api_error_per_minute", 103l);
        apiStat.put("api_count_per_minute", 987l);


        AlertRuleInterpreter interpreter = new AlertRuleInterpreter("api_error_per_minute > 100 || api_count_per_minute > 10000");
        boolean interpret = interpreter.interpret(apiStat);
        System.out.println(interpret);
    }
}
