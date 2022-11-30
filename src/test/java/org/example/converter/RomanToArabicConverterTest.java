package org.example.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanToArabicConverterTest {
    Converter<Integer, String> converter;

    @BeforeEach
    void setUp() {
        converter = new RomanToArabicConverter();
    }

    @ParameterizedTest
    @CsvSource({"CD,400", "DCCC,800", "XIX,19", "LXXX,80"})
    void convertRoman(String input, int expected) {
        assertEquals(expected, converter.convert(input).get());
    }

}