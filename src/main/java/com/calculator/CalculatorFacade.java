package com.calculator;

import com.calculator.parser.ExpressionParser;
import com.calculator.strategy.ExpressionHandler;
import com.calculator.validator.ExpressionValidator;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class CalculatorFacade {

    private final ExpressionValidator validator;
    private final ExpressionParser parser;
    private final ExpressionHandler expressionCalculator;

    public BigDecimal calculate(String input) {
        validator.validate(input);

        var values = parser.parseExpression(input)
                .getValues();

        var result = calculateFirstExpression(values[0], values[1], values[2]);

        for (int i = 3; i < values.length; i = i + 2) {
            var sign = values[i];
            var nextNumber = values[i + 1];
            result = expressionCalculator.calculate(result, sign, nextNumber);
        }

        return result;
    }

    private BigDecimal calculateFirstExpression(String firstNumber, String sign, String secondNumber) {
        return expressionCalculator.calculate(new BigDecimal(firstNumber), sign, secondNumber);
    }
}
