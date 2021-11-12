package io.github.plizzzhealme.calculator.util;

import io.github.plizzzhealme.calculator.PostfixNotationCalculator;

import java.util.*;

import static io.github.plizzzhealme.calculator.PostfixNotationCalculator.*;

public class Converter {

    private static final Map<String, Integer> OPERAND_PRIORITIES;

    static {
        OPERAND_PRIORITIES = new HashMap<>();
        OPERAND_PRIORITIES.put(PostfixNotationCalculator.LEFT_PARENTHESIS, 0);
        OPERAND_PRIORITIES.put(PLUS, 1);
        OPERAND_PRIORITIES.put(MINUS, 1);
        OPERAND_PRIORITIES.put(MULTIPLY, 2);
        OPERAND_PRIORITIES.put(DIVIDE, 2);
    }

    private Converter() {
    }

    public static List<String> convertInfixToPostfix(List<String> expression) {

        List<String> postfixExpression = new ArrayList<>();
        Deque<String> operands = new LinkedList<>();

        for (String token : expression) {
            switch (token) {
                case LEFT_PARENTHESIS -> addLeftParenthesis(operands);

                case RIGHT_PARENTHESIS -> addRightParenthesis(postfixExpression, operands);

                case MULTIPLY, DIVIDE, PLUS, MINUS -> addOperand(postfixExpression, operands, token);

                default -> addNumber(postfixExpression, token);
            }
        }

        while (!operands.isEmpty()) {
            postfixExpression.add(operands.pop());
        }

        return postfixExpression;
    }

    private static void addNumber(List<String> postfixExpression, String number) {
        postfixExpression.add(number);
    }

    private static void addLeftParenthesis(Deque<String> operandsStack) {
        operandsStack.push(LEFT_PARENTHESIS);
    }

    private static void addRightParenthesis(List<String> postfixExpression, Deque<String> operands) {
        while (!(operands.isEmpty() || operands.peek().equals(LEFT_PARENTHESIS))) {
            postfixExpression.add(operands.pop());
        }
        operands.pop();
    }

    private static void addOperand(List<String> postfixExpression, Deque<String> operands, String operand) {
        while (hasLowerPriority(operands, operand)) {
            postfixExpression.add(operands.pop());
        }
        operands.push(operand);
    }

    private static boolean hasLowerPriority(Deque<String> operands, String operand) {
        if (operands.isEmpty()) {
            return false;
        }

        return OPERAND_PRIORITIES.get(operands.peek()) >= OPERAND_PRIORITIES.get(operand);
    }
}
