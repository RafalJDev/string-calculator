package com.calculator.strategy;

import java.math.BigDecimal;

class DivisionStrategy extends CalculatorStrategy{
    @Override
    BigDecimal calculate(BigDecimal result, BigDecimal nextNumber) {
        return result.divide(nextNumber);
    }
}
