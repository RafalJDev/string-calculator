package com.calculator.strategy;

import java.math.BigDecimal;
import java.util.Map;

public class ExpressionHandler {

    private static final Map<String, CalculatorStrategy> signToStrategyMap = Map.of(
            "+", new AdditionStrategy(),
            "-", new SubtractionStrategy(),
            "*", new MultiplicationStrategy(),
            "/", new DivisionStrategy()
    );


    public BigDecimal calculate(BigDecimal result, String sign, String nextNumber) {
        return signToStrategyMap.get(sign)
                .calculate(result, new BigDecimal(nextNumber));
    }
}
