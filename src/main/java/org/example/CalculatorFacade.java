package org.example;

import org.example.calculator.impl.ArabianCalculator;
import org.example.calculator.impl.RomanCalculator;
import org.example.validator.InputValidator;
import org.example.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class CalculatorFacade implements CalculatorApp {
    private static Logger logger = LoggerFactory.getLogger(CalculatorFacade.class);
    private RomanCalculator romanCalculator;
    private ArabianCalculator arabianCalculator;
    private Validator validator;

    public CalculatorFacade() {
        this.romanCalculator = new RomanCalculator();
        this.arabianCalculator = new ArabianCalculator();
        this.validator = new InputValidator();
    }

    @Override
    public String calculate(String values) throws Exception {
        List<String> validate = validator.validate(values);

        if (validate.size() == 0) {
            logger.error("Non valid arguments length: " + values);
            throw new Exception("Non valid arguments length");
        }

        String a = validate.get(0);
        String b = validate.get(2);
        String operand = validate.get(1);

        Optional<String> result;
        if (arabianCalculator.isValid(a, b)){
            result = arabianCalculator.calculate(a, b, operand);
        } else {
            result = romanCalculator.calculate(a,b, operand);
        }

        return result.orElseThrow(Exception::new);
    }
}
