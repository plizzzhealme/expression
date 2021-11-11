package io.github.plizzzhealme.calculator.postfix;

import io.github.plizzzhealme.calculator.Calculator;
import io.github.plizzzhealme.calculator.PostfixNotationCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixNotationCalculatorTest {

    @Test
    void calculate() {
        Calculator calculator = new PostfixNotationCalculator();

        int expected = 45;
        int actual = calculator.calculate("3*(9+6)");
        assertEquals(expected, actual);
    }
}