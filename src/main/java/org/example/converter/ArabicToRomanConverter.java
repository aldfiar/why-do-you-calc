package org.example.converter;

import org.example.common.RomanNumeral;

import java.util.Optional;
import java.util.Queue;

public class ArabicToRomanConverter implements Converter<String, Integer> {

    private static final RomanNumeral ROMAN_NUMERAL = new RomanNumeral();

    @Override
    public Optional<String> convert(Integer value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Negative number");
        }

        StringBuilder sb = new StringBuilder();
        Queue<String> keysDesc = ROMAN_NUMERAL.getKeysDesc();

        while (value > 0 && keysDesc.size() > 0) {
            String numeral = keysDesc.poll();
            int anInt = ROMAN_NUMERAL.getInt(numeral);
            while (anInt <= value) {
                sb.append(numeral);
                value -= anInt;
            }
        }

        String result = sb.toString();

        return (result.length() == 0) ? Optional.empty() : Optional.of(result);
    }
}
