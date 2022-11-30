package org.example.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator implements Validator {

    @Override
    public List<String> validate(String input) {
        String[] s = input.split(" ");
        if (s.length != 3) {
            return new ArrayList<>();
        } else {
            return Arrays
                    .stream(s)
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
    }

}
