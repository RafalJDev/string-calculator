package com.calculator.strategy;

import java.math.BigDecimal;

class SubtractionStrategy extends CalculatorStrategy {
    @Override
    BigDecimal calculate(BigDecimal result, BigDecimal nextNumber) {
        return result.subtract(nextNumber);
    }
}
