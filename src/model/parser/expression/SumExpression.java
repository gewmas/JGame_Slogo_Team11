package model.parser.expression;

import java.util.List;
import model.parser.DefaultParser;

public class SumExpression extends Expression {
    Expression expression1;
    Expression expression2;

    public SumExpression(List<String> cmdList, int begin) {
        convert(cmdList, begin);
    }

    public void convert(List<String> cmdList, int begin) {
        cmdList.remove(begin);
        
        // sum sum 1 2 sum 3 4
        try
        {
            expression1 = new NumberExpression(Double.parseDouble(cmdList.get(begin)));
        }
        catch(NumberFormatException e)
        {
            expression1 = DefaultParser.parse(cmdList, begin);
        }

        try
        {
            expression2 = new NumberExpression(Double.parseDouble(cmdList.get(begin+1)));
        }
        catch(NumberFormatException e)
        {
            expression1 = DefaultParser.parse(cmdList, begin+1);
        }

    }

}
