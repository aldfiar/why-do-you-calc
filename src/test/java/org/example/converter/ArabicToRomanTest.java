package org.example.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ArabicToRomanTest {
    Converter<String, Integer> converter;

    @BeforeEach
    void setUp() {
        converter = new ArabicToRomanConverter();
    }

    @ParameterizedTest
    @CsvSource({"CD,400", "DCCC,800", "XIX,19", "LXXX,80", "MCMXCIX,1999"})
    void convertRoman(String expected, int input) {
        assertEquals(expected, converter.convert(input).get());
    }
}