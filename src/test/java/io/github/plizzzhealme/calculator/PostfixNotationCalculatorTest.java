package io.github.plizzzhealme.calculator;

import io.github.plizzzhealme.calculator.exception.CalculatorException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void calculateWithInvalidParameters() {
        Calculator calculator = CalculatorFactory.getInstance().getCalculator();

        assertThrows(CalculatorException.class, () -> calculator.calculate("abc"));
    }

    @Test
    void calculateWithNull() {
        Calculator calculator = CalculatorFactory.getInstance().getCalculator();

        assertThrows(CalculatorException.class, () -> calculator.calculate(null));
    }
}