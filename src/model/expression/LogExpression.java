package model.expression;

import java.util.ArrayList;
import java.util.List;

public class LogExpression extends OneParameterExpression {

    public LogExpression (List<String> cmdList) {
        super(cmdList);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        NumberExpression exp = (NumberExpression) expression;
        finalExpressionList.add(exp.log());
        return finalExpressionList;
    }

}
