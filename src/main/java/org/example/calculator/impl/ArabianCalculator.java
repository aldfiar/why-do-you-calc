package org.example.calculator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.BiFunction;

public class ArabianCalculator extends AbstractCalculator<Integer> {

    private static Logger logger = LoggerFactory.getLogger(ArabianCalculator.class);

    public ArabianCalculator() {
        super(new OperandIntImpl());
    }

    @Override
    Optional<String> internalCalculation(String a, String b, BiFunction<Integer, Integer, Integer> function) {
        Integer result = null;

        try {
            int first = Integer.parseInt(a);
            int second = Integer.parseInt(b);
            result = function.apply(first, second);
        } catch (NumberFormatException ex) {
            logger.error(String.format("Can't format values: %s, %s", a, b));
        }

        return Optional.ofNullable(result).map(String::valueOf);
    }
}
