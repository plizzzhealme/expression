package io.github.plizzzhealme.calculator.util;

import java.util.List;

public class Validator {

    public static final String NUMBER = "^[0-9]+$";
    public static final String OPERATION = "[+-/*()]";

    private Validator() {}

    public static boolean isValidExpression(List<String> tokens) {
        return tokens.stream().allMatch(t -> t.matches(NUMBER) || t.matches(OPERATION));
    }
}
