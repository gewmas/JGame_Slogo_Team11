package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import model.parser.DefaultParser;
import controller.TurtleCommand;


public abstract class OneParameterExpression extends Expression {
    Expression expression;

    public OneParameterExpression (List<String> cmdList) throws SlogoException {
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0);

        try
        {
            expression = new NumberExpression(Double.parseDouble(cmdList.get(0)));
            cmdList.remove(0);
        }
        catch (NumberFormatException e)
        {
            expression = DefaultParser.parse(cmdList);
        }

    }

    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.addAll(expression.evaluate());
        return finalExpressionList;
    }

   

}
