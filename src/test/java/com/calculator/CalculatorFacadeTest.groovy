package com.calculator

import com.calculator.parser.ExpressionParserImpl
import com.calculator.strategy.ExpressionHandler
import com.calculator.validator.ExpressionValidator
import spock.lang.Specification
import spock.lang.Unroll

class CalculatorFacadeTest extends Specification {

    CalculatorFacade calculator

    void setup() {
        calculator = new CalculatorFacade(
                new ExpressionValidator(),
                new ExpressionParserImpl(),
                new ExpressionHandler()
        )
    }

    @Unroll
    def "should calculate expressions"() {
        expect:

            def result = calculator.calculate(input)

            result == expectedResult
        where:
            input        | expectedResult
            "2 + 3"      | new BigDecimal(5)
            "3 * 2 + 1"  | new BigDecimal(7)
            "3 * -2 + 6" | new BigDecimal(0)
    }
}
