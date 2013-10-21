package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import Exceptions.SlogoException;


public abstract class OneParameterExpression extends Expression {
    Expression expression;

    public OneParameterExpression (List<String> cmdList, Model model) throws SlogoException {
        super(model);
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0);

        try
        {
            expression = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch (NumberFormatException e)
        {
            expression = model.getParser().parse(cmdList);
        }

    }

    @Override
    public List<Expression> evaluate () throws SlogoException {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.addAll(expression.evaluate());
        return finalExpressionList;
    }

}
