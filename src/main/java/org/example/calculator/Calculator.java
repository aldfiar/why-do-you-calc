package org.example.calculator;

import java.util.Optional;

public interface Calculator {
    Optional<String> calculate(String a, String b, String operand);
}
