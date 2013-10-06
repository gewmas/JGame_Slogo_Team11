package model.expression;

import java.util.ArrayList;
import java.util.List;

public class SumExpression extends TwoParameterExpression {

    public SumExpression(List<String> cmdList) {
        super(cmdList);
    }

    @Override
    public List<Expression> evaluate () {
        
        
        if(!(expression1 instanceof NumberExpression)){
            expression1 = expression1.evaluate().get(0);
        }

        if(!(expression2 instanceof NumberExpression)){
            expression2 = expression2.evaluate().get(0);
        }

        List<Expression> finalExpressionList = new ArrayList<Expression>();

        NumberExpression exp1 = (NumberExpression) expression1;
        NumberExpression exp2 = (NumberExpression) expression2;
        finalExpressionList.add(exp1.sum(exp2));
        return finalExpressionList;
    }



}
