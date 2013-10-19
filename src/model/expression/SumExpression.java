package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import Exceptions.SlogoException;

public class SumExpression extends TwoParameterExpression {

    public SumExpression(List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }

    @Override
    public List<Expression> evaluate () {
        
        List<NumberExpression> expList = preEvaluate();
      
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.add(expList.get(0).sum(expList.get(1)));
        return finalExpressionList;
    }



}
