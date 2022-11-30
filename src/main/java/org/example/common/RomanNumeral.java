package org.example.common;

import java.util.*;
import java.util.stream.Collectors;

public class RomanNumeral {
    private final Map<String, Integer> numerals = new HashMap<>();
    private final Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);

    public RomanNumeral() {
        numerals.put("I", 1);
        numerals.put("IV", 4);
        numerals.put("V", 5);
        numerals.put("IX", 9);
        numerals.put("X", 10);
        numerals.put("XL", 40);
        numerals.put("L", 50);
        numerals.put("XC", 90);
        numerals.put("C", 100);
        numerals.put("CD", 400);
        numerals.put("D", 500);
        numerals.put("CM", 900);
        numerals.put("M", 1000);
    }

    public int getInt(String value) {
        return numerals.getOrDefault(value, 0);
    }

    public Queue<String> getKeysDesc() {
        return numerals.entrySet()
                .stream()
                .sorted(comparator.reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(LinkedList::new));
    }


}
