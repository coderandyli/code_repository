package com.coderandyli.designpattern.chapter_08.section_72.case_02;

import com.coderandyli.designpattern.chapter_08.section_72.case_02.expression.*;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/4/17 下午3:02
 */
public class ExpressionInterpreter {
    private Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length+1)/2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i = (length+1)/2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = checkIfValid(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();

            Expression combinedExp = null;
            if (operator.equals("+")) {
                combinedExp = new AdditionExpression(exp1, exp2);
            } else if (operator.equals("-")) {
                combinedExp = new SubstractionExpression(exp1, exp2);
            } else if (operator.equals("*")) {
                combinedExp = new MultiplicationExpression(exp1, exp2);
            } else if (operator.equals("/")) {
                combinedExp = new DivisionExpression(exp1, exp2);
            }
            long result = combinedExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }

        return numbers.pop().interpret();
    }

    private boolean checkIfValid(String operator) {
        return  "+".equals(operator) || "-".equals(operator)
                || "*".equals(operator) || "/".equals(operator);
    }
}
