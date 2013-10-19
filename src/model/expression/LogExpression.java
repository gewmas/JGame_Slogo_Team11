package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import Exceptions.SlogoException;

public class LogExpression extends OneParameterExpression {

    public LogExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }
    
    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        NumberExpression exp = (NumberExpression) expression;
        finalExpressionList.add(exp.log());
        return finalExpressionList;
    }

}
