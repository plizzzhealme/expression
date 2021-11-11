package io.github.plizzzhealme.calculator;

import io.github.plizzzhealme.calculator.exception.CalculatorException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostfixNotationCalculator implements Calculator {

    @Override
    public int calculate(String expression) {
        ExpressionParser parser = new ExpressionParser();
        List<String> parsedExpression = parser.parse(expression);

        if (!Validator.isValidExpression(parsedExpression)) {
            throw new CalculatorException("Incorrect expression");
        }

        List<String> postfixNotationExpression = Converter.convertToPostfixNotation(parsedExpression);
        return calcValue(postfixNotationExpression);
    }

    private int calcValue(List<String> postfixNotationExpression) {
        if (postfixNotationExpression == null) {
            throw new CalculatorException("Expression is not instantiated");
        }

        Deque<String> stack = new LinkedList<>();

        for (String token : postfixNotationExpression) {
            switch (token) {
                case "+" -> add(stack);
                case "-" -> subtract(stack);
                case "*" -> multiply(stack);
                case "/" -> divide(stack);
                default -> stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private void divide(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 / x1));
    }

    private void multiply(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 * x1));
    }

    private void subtract(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 - x1));
    }

    private void add(Deque<String> stack) {
        int x1 = Integer.parseInt(stack.pop());
        int x2 = Integer.parseInt(stack.pop());
        stack.push(String.valueOf(x2 + x1));
    }
}
