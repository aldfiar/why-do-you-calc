package org.example.calculator.impl;

import org.example.calculator.Operands;

public class OperandIntImpl implements Operands<Integer> {
    @Override
    public Integer multiplication(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer division(Integer a, Integer b) {
        return a / b;
    }

    @Override
    public Integer addition(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer subtraction(Integer a, Integer b) {
        return a - b;
    }
}
