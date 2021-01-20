package com.calculator.validator;

import java.util.Objects;

public class ExpressionValidator {

    private static final String NUMBER = "(\\-?\\d+)";
    private static final String MATHEMATICAL_OPERATORS = "(\\*|\\/|\\+|\\-)";

    // @formatter:off
    private static final String MATHEMATICAL_EXPRESSION_REGEX =
            "^("+NUMBER+"\\s" +
            MATHEMATICAL_OPERATORS +
            "\\s)+" +
                    NUMBER;
    // @formatter:off

    public void validate(String input) {
        if (Objects.isNull(input)) {
            throw new RuntimeException("Input is null!");
        }

        if (!input.matches(MATHEMATICAL_EXPRESSION_REGEX)) {
            throw new RuntimeException("It's not a correct expression: " + input);
        }
    }
}
