package io.github.plizzzhealme.calculator.postfix;

import io.github.plizzzhealme.calculator.Calculator;
import io.github.plizzzhealme.calculator.CalculatorFactory;
import io.github.plizzzhealme.calculator.PostfixNotationCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixNotationCalculatorTest {

    @Test
    void calculateSimpleExample() {
        Calculator calculator = CalculatorFactory.getInstance().getCalculator();

        int expected = 4;
        int actual = calculator.calculate("2*2");

        assertEquals(expected, actual);
    }

    @Test
    void calculateComplexExample() {
        Calculator calculator = CalculatorFactory.getInstance().getCalculator();

        int expected = 4;
        int actual = calculator.calculate("2*(3+5)/(2+2)");

        assertEquals(expected, actual);
    }
}