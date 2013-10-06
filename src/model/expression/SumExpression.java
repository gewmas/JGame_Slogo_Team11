package model.expression;

import java.util.ArrayList;
import java.util.List;

public class SumExpression extends TwoParameterExpression {
    Expression expression1;
    Expression expression2;

    public SumExpression(List<String> cmdList) {
        super(cmdList);
    }

    @Override
    public List<Expression> evaluate () {
        
        List<NumberExpression> expList = preEvaluate();
        
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(expList.get(0).sum(expList.get(1)));
        return finalExpressionList;
    }



}
