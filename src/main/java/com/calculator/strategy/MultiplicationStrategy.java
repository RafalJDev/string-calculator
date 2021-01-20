package com.calculator.strategy;

import java.math.BigDecimal;

class MultiplicationStrategy extends CalculatorStrategy {
    @Override
    BigDecimal calculate(BigDecimal result, BigDecimal nextNumber) {
        return result.multiply(nextNumber);
    }
}
