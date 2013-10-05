package model.expression;

import java.util.List;
import model.parser.DefaultParser;

public class TwoParameterExpression extends Expression {
    Expression expression1;
    Expression expression2;

    public TwoParameterExpression(List<String> cmdList) {
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
        // TODO Auto-generated method stub
        return null;
    }

}
