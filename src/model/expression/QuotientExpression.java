package model.expression;

import java.util.ArrayList;
import java.util.List;

public class QuotientExpression extends TwoParameterExpression {

    public QuotientExpression (List<String> cmdList) {
        super(cmdList);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<Expression> evaluate () {
        
        List<NumberExpression> expList = preEvaluate();
        
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(expList.get(0).divide(expList.get(1)));
        return finalExpressionList;
    }

}
