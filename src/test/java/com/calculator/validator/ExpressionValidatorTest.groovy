package com.calculator.validator


import spock.lang.Specification
import spock.lang.Unroll

class ExpressionValidatorTest extends Specification {

    ExpressionValidator validator

    void setup() {
        validator = new ExpressionValidator()
    }

    @Unroll
    def "should validate valid expressions"() {
        when: "validation passes"
            validator.validate(input)

        then:
            true

        where:
            input << [
                    "2 + 3",
                    "3 * 2 + 1",
                    "3 * -2 + 6",
            ]
    }

    @Unroll
    def "should validate invalid expressions"() {
        when:
            validator.validate(input)

        then:
            def error = thrown(expectedException)
            error.message == expectedMessage
        where:
            input | expectedException | expectedMessage
            null  | RuntimeException  | "Input is null!"
            ""    | RuntimeException  | "It's not a correct expression: "
            "3"   | RuntimeException  | "It's not a correct expression: 3"
            "3 -" | RuntimeException  | "It's not a correct expression: 3 -"
            "-3 " | RuntimeException  | "It's not a correct expression: -3 "
            "-3 3" | RuntimeException  | "It's not a correct expression: -3 3"
            "3 / 0" | RuntimeException  | "Division by 0 is prohibited!"
    }

}
