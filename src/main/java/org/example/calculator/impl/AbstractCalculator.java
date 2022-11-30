package org.example.calculator.impl;

import org.example.calculator.Calculator;
import org.example.calculator.Operands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.function.BiFunction;

public abstract class AbstractCalculator<T> implements Calculator {
    private static Logger logger = LoggerFactory.getLogger(AbstractCalculator.class);
    protected Operands<T> operands;

    public AbstractCalculator(Operands<T> operands) {
        this.operands = operands;
    }

    abstract Optional<String> internalCalculation(String a, String b, BiFunction<T, T, T> function);

    public Optional<BiFunction<T, T, T>> findOperand(String value) {
        BiFunction<T, T, T> function = null;

        switch (value.toLowerCase()) {
            case "+":
                function = operands::addition;
                break;
            case "-":
                function = operands::subtraction;
                break;
            case "*":
                function = operands::multiplication;
                break;
            case "/":
                function = operands::division;
                break;
        }

        return function == null ? Optional.empty() : Optional.of(function);
    }

    @Override
    public Optional<String> calculate(String a, String b, String operand) {
        Optional<BiFunction<T, T, T>> function = this.findOperand(operand);
        if (function.isEmpty()) {
            logger.error("Operand is not found or supported: " + operand);
        }

        return function.flatMap(t -> this.internalCalculation(a, b, t));
    }
}
