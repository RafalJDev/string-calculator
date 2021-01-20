package com.calculator.strategy;

import java.math.BigDecimal;

class AdditionStrategy extends CalculatorStrategy {

    @Override
    BigDecimal calculate(BigDecimal result, BigDecimal secondNumber) {
        return result.add(secondNumber);
    }

}
