package model.expression;

import java.util.ArrayList;
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
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(this);
        return finalExpressionList;
    }

    public Expression sum (NumberExpression rhs) {
        return new NumberExpression(getNumber() + rhs.getNumber());
    }

    public double getNumber () {
        return number;
    }

}
