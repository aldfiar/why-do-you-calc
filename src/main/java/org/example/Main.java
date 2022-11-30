package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            logger.error("Provide arguments");
            System.exit(1);
        }

        CalculatorApp calculator = new CalculatorFacade();
        String calculate = calculator.calculate(args[0]);
        System.out.println(calculate);
    }
}