package model.parser.expression;

import java.util.List;
import model.parser.DefaultParser;

public class ForwardExpression extends Expression {
    Expression expression;
    
    public ForwardExpression(List<String> cmdList){
        convert(cmdList);
    }
    
    public void convert(List<String> cmdList) {
        cmdList.remove(0);
        
        try
        {
            expression = new NumberExpression(Double.parseDouble(cmdList.get(0)));
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression = DefaultParser.parse(cmdList);
        }
        
    }
    
    @Override
    public Expression evaluate () {
        expression = expression.evaluate();
        return this;
    }

}
