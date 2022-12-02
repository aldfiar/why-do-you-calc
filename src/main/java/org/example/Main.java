package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        boolean isRunning = true;

        CalculatorApp calculator = new CalculatorFacade();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (isRunning) {
                System.out.println("Waiting for input: ");
                String inputRaw = br.readLine();
                String[] input = inputRaw.split("\n");
                if (input.length > 1) {
                    System.err.println("Wrong input");
                }
                String calculate = calculator.calculate(input[0]);
                System.out.println(calculate);
            }
        }
    }
}