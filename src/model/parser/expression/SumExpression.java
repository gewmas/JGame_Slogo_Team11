package model.parser.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;

public class SumExpression extends Expression {
    Expression expression1;
    Expression expression2;

    public SumExpression(List<String> cmdList) {
        convert(cmdList);
    }

    public void convert(List<String> cmdList) {
        cmdList.remove(0);

        // sum sum 1 2 sum 3 4
        try
        {
            expression1 = new NumberExpression(Double.parseDouble(cmdList.get(0)));
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression1 = DefaultParser.parse(cmdList);
        }

        try
        {
            expression2 = new NumberExpression(Double.parseDouble(cmdList.get(0)));
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression2 = DefaultParser.parse(cmdList);
        }

    }

    @Override
    public List<Expression> evaluate () {
        if(!(expression1 instanceof NumberExpression)){
            expression1 = expression1.evaluate().get(0);
        }

        if(!(expression2 instanceof NumberExpression)){
            expression2 = expression2.evaluate().get(0);
        }

        List<Expression> finalExpressionList = new ArrayList<Expression>();

        NumberExpression exp1 = (NumberExpression) expression1;
        NumberExpression exp2 = (NumberExpression) expression2;
        finalExpressionList.add(exp1.sum(exp2));
        return finalExpressionList;
    }

}
