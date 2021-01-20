package com.calculator.strategy;

import java.math.BigDecimal;

abstract class CalculatorStrategy {

    abstract BigDecimal calculate(BigDecimal result, BigDecimal nextNumber);

}
