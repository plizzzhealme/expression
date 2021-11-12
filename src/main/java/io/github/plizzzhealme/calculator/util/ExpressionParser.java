package io.github.plizzzhealme.calculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExpressionParser {

    public static final String DELIMITERS = "()*/+-";

    private ExpressionParser() {
    }

    public static List<String> parse(String expression) {
        List<String> result = new ArrayList<>();
        StringTokenizer expressionTokenizer = new StringTokenizer(expression, DELIMITERS, true);

        while (expressionTokenizer.hasMoreTokens()) {
            result.add(expressionTokenizer.nextToken());
        }

        return result;
    }
}
