package io.github.plizzzhealme.calculator.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {

    @Test
    void parse() {
        List<String> expected = new ArrayList<>();
        expected.add("2");
        expected.add("*");
        expected.add("2");

        assertEquals(expected, ExpressionParser.parse("2*2"));
    }
}