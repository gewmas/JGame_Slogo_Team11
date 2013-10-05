package model.parser.expression;

import java.util.List;

public class SumExpression extends TwoParameterExpression {
    Expression expression1;
    Expression expression2;

    public SumExpression(List<String> cmdList) {
        super(cmdList);
    }

    @Override
    public Expression evaluate () {
        if(!(expression1 instanceof NumberExpression)){
            expression1 = expression1.evaluate();
        }
        
        if(!(expression2 instanceof NumberExpression)){
            expression2 = expression2.evaluate();
        }
        
//        if(expression1 instanceof NumberExpression && expression2 instanceof NumberExpression){
            NumberExpression exp1 = (NumberExpression) expression1;
            NumberExpression exp2 = (NumberExpression) expression2;
            return exp1.sum(exp2);
//        }
        
        
//        return null;
    }



}
