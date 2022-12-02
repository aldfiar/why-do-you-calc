package org.example.calculator.impl;

import org.example.converter.ArabicToRomanConverter;
import org.example.converter.Converter;
import org.example.converter.RomanToArabicConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.BiFunction;

public class RomanCalculator extends AbstractCalculator<Integer> {
    private static Logger logger = LoggerFactory.getLogger(RomanCalculator.class);
    private Converter<Integer, String> romanToArabicConverter;
    private Converter<String, Integer> arabicToRomanConverter;

    public RomanCalculator() {
        super(new OperandIntImpl());
        this.romanToArabicConverter = new RomanToArabicConverter();
        this.arabicToRomanConverter = new ArabicToRomanConverter();
    }

    @Override
    Optional<String> internalCalculation(String a, String b, BiFunction<Integer, Integer, Integer> function) {
        Optional<Integer> first = romanToArabicConverter.convert(a);
        Optional<Integer> second = romanToArabicConverter.convert(b);

        if (first.isEmpty() || second.isEmpty()) {
            logger.warn(String.format("Can't convert values: %s, %s", a, b));
            return Optional.empty();
        }

        Integer result = function.apply(first.get(), second.get());
        return arabicToRomanConverter.convert(result);
    }

    @Override
    public boolean isValid(String a, String b) {
        boolean valid = false;
        try {
            int first = Integer.parseInt(a);
            int second = Integer.parseInt(b);
        } catch (NumberFormatException ex) {
            logger.warn(String.format("Can't format values: %s, %s", a, b));
            valid = true;
        }
        return valid;
    }

    @Override
    public Optional<BiFunction<Integer, Integer, Integer>> findOperand(String value) {
        BiFunction<Integer, Integer, Integer> function = null;

        switch (value.toLowerCase()) {
            case "+":
                function = operands::addition;
                break;
            case "*":
                function = operands::multiplication;
                break;
            case "/":
                function = operands::division;
                break;
        }

        if (function == null) {
            logger.error("Operand is not supported: " + value);
        }

        return Optional.ofNullable(function);
    }
}
