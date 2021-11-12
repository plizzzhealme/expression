package io.github.plizzzhealme.calculator.util;

import io.github.plizzzhealme.calculator.util.Converter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConverterTest {

    @Test
    void correctConversion() {
        List<String> input = new ArrayList<>();
        input.add("2");
        input.add("*");
        input.add("2");

        List<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("2");
        expected.add("*");

        assertEquals(expected, Converter.convertInfixToPostfix(input));
    }
}
