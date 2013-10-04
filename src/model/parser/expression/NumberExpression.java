package model.parser.expression;

import java.util.List;


public class NumberExpression extends Expression {
    double number;

    public NumberExpression (double d) {
        number = d;
    }

    @Override
    public void convert (List<String> cmdList) {
        // TODO Auto-generated method stub

    }

    @Override
    public Expression evaluate () {
        return this;
    }

    public Expression sum (NumberExpression rhs) {
        return new NumberExpression(getNumber() + rhs.getNumber());
    }

    public double getNumber () {
        return number;
    }

}
