package org.example.calculator;

import org.example.CalculatorApp;
import org.example.CalculatorFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorImplTest {
    private CalculatorApp calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorFacade();
    }

    @Test
    public void testTwoArabian() throws Exception {
        String input = "1 + 2";
        String result = calculator.calculate(input);
        assertEquals("3", result);
    }

    @Test
    public void testTwoRoman() throws Exception {
        String input = "VI / III";
        String result = calculator.calculate(input);
        assertEquals("II", result);
    }

    @Test
    public void testTwoRomanNegativeThrowsException() {
        String input = "I - II";
        assertThrows(Exception.class, () -> calculator.calculate(input));
    }

    @Test
    public void testMixedTypesThrowsException() {
        String input = "I + 1";
        assertThrows(Exception.class, () -> calculator.calculate(input));
    }

    @Test
    public void testNonMathOperationThrowsException() {
        String input = "1";
        assertThrows(Exception.class, () -> calculator.calculate(input));
    }

    @Test
    public void testThreeOperandsThrowsException() {
        String input = "1 + 2 + 3";
        assertThrows(Exception.class, () -> calculator.calculate(input));
    }

}