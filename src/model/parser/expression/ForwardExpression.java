package model.parser.expression;

import java.util.ArrayList;
import java.util.List;

public class ForwardExpression extends OneParameterExpression {

    public ForwardExpression (List<String> cmdList) {
        super(cmdList);

    
    @Override
    public List<Expression> evaluate () {
    	List<Expression> finalExpressionList = new ArrayList<Expression>();
    	finalExpressionList.addAll(expression.evaluate());
        return finalExpressionList;

    }

}
