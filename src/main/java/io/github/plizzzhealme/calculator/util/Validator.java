package io.github.plizzzhealme.calculator.util;

import java.util.List;
import java.util.stream.IntStream;

public class Validator {

    public static final String NUMBER = "^[0-9]+$";
    public static final String OPERATION = "[+-/*]";
    public static final String PARENTHESIS = "[()]";

    private Validator() {
    }

    public static boolean isValidExpression(List<String> tokens) {
        return hasValidTokens(tokens)
                && hasValidTokensOrder(tokens)
                && hasValidParenthesis(tokens);
    }

    private static boolean hasValidTokens(List<String> tokens) {
        return tokens.stream()
                .allMatch(t -> t.matches(NUMBER) || t.matches(OPERATION) || t.matches(PARENTHESIS));
    }

    private static boolean hasValidTokensOrder(List<String> tokens) {
        return IntStream
                .range(0, tokens.size() - 1)
                .noneMatch(i -> tokens.get(i).matches(OPERATION) && tokens.get(i + 1).matches(OPERATION));
    }

    private static boolean hasValidParenthesis(List<String> tokens) {
        long n1 = tokens.stream().filter(t -> t.equals("(")).count();
        long n2 = tokens.stream().filter(t -> t.equals(")")).count();

        return n1 == n2;
    }
}
