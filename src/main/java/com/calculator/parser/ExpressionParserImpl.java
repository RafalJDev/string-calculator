package com.calculator.parser;

public class ExpressionParserImpl implements ExpressionParser {

    @Override
    public ParserResult parseExpression(String input) {
        return new ParserResult(
                input.split(" ")
        );
    }

}
