package com.coderandyli.designpattern.chapter_08.section_72.case_04;

import java.util.Map;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/20 上午10:26
 */
public interface Expression {
    boolean interpret(Map<String, Long> stats);
}
