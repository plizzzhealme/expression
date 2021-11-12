package io.github.plizzzhealme.calculator;

public final class CalculatorFactory {

    private static final CalculatorFactory instance = new CalculatorFactory();
    private final Calculator calculator = new PostfixNotationCalculator();

    private CalculatorFactory() {}

    public static CalculatorFactory getInstance() {
        return instance;
    }

    public Calculator getCalculator() {
        return calculator;
    }
}
