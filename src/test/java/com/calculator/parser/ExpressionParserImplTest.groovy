package com.calculator.parser

import spock.lang.Specification
import spock.lang.Unroll

class ExpressionParserImplTest extends Specification {

    @Unroll
    def "should parse expressions"() {
        expect:
            def parser = new ExpressionParserImpl()
            def result = parser.parseExpression(input)

            result.getValues() == expectedResult
        where:
            input        | expectedResult
            "2 + 3"      | ["2", "+", "3"]
            "3 * 2 + 1"  | ["3", "*", "2", "+", "1"]
            "3 * -2 + 6" | ["3", "*", "-2", "+", "6"]
    }

}
