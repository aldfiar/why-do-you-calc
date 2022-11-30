package org.example.converter;

import org.example.common.RomanNumeral;

import java.util.Optional;
import java.util.Queue;

public class RomanToArabicConverter implements Converter<Integer, String> {
    private static final RomanNumeral ROMAN_NUMERAL = new RomanNumeral();

    @Override
    public Optional<Integer> convert(String value) {
        String result = value.toUpperCase();
        int arabicValue = 0;
        Queue<String> keysDesc = ROMAN_NUMERAL.getKeysDesc();

        while (result.length() > 0 && keysDesc.size() > 0) {
            String numeral = keysDesc.poll();
            while (result.startsWith(numeral)) {
                arabicValue += ROMAN_NUMERAL.getInt(numeral);
                result = result.substring(numeral.length());
            }
        }

        return (result.length() > 0) ? Optional.empty() : Optional.of(arabicValue);
    }
}
