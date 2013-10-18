package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;

public class CosExpression extends OneParameterExpression {

    public CosExpression (List<String> cmdList) throws SlogoException {
        super(cmdList);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        NumberExpression exp = (NumberExpression) expression;
        finalExpressionList.add(exp.cos());
        return finalExpressionList;
    }

}
