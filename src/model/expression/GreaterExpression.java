package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;

public class GreaterExpression extends TwoParameterExpression {

    public GreaterExpression (List<String> cmdList) throws SlogoException {
        super(cmdList);
        // TODO Auto-generated constructor stub
    }

    @Override
    public List<Expression> evaluate () {
        
        List<NumberExpression> expList = preEvaluate();
        
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(expList.get(0).greater(expList.get(1)));
        return finalExpressionList;
    }
    
}
