package model.expression;

import java.util.ArrayList;
import java.util.List;

public class TanExpression extends OneParameterExpression {

    public TanExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        NumberExpression exp = (NumberExpression) expression;
        finalExpressionList.add(exp.tan());
        return finalExpressionList;
    }

}
