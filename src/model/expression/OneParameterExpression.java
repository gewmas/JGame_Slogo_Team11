package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;
import controller.TurtleCommand;


public abstract class OneParameterExpression extends Expression {
    Expression expression;
    private DefaultParser parser;

    public OneParameterExpression (List<String> cmdList, DefaultParser parser) {
        convert(cmdList);
        this.parser = parser;
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);

        try
        {
            expression = new NumberExpression(Double.parseDouble(cmdList.get(0)));
            cmdList.remove(0);
        }
        catch (NumberFormatException e)
        {
            expression = parser.parse(cmdList);
        }

    }

    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.addAll(expression.evaluate());
        return finalExpressionList;
    }

   

}
