package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import model.Model;

public class TwoParameterExpression extends Expression {
    Expression expression1;
    Expression expression2;
    

    public TwoParameterExpression(List<String> cmdList, Model model) throws SlogoException {
        super(model);
        convert(cmdList);
    }

    public void convert(List<String> cmdList) throws SlogoException {
        cmdList.remove(0);
        
        // sum sum 1 2 sum 3 4
        try
        {
            expression1 = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression1 = model.getParser().parse(cmdList);
        }

        try
        {
            expression2 = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression2 = parser.parse(cmdList);
        }

    }

    @Override
    public List<Expression> evaluate () throws SlogoException {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        return finalExpressionList;
    }
    
    public List<NumberExpression> preEvaluate () throws SlogoException {
      Expression evaluatedExpression1 = expression1;
      Expression evaluatedExpression2 = expression2;
        
        if(expression1 instanceof VariableExpression){
            evaluatedExpression1 = new VariableExpression((VariableExpression)expression1, model);
        }
        
        if(!(expression1 instanceof NumberExpression)){
            evaluatedExpression1 = expression1.evaluate().get(0);
        }
        
        if(expression2 instanceof VariableExpression){
            evaluatedExpression2 = new VariableExpression((VariableExpression)expression2, model);
        }
        
        if(!(expression2 instanceof NumberExpression)){
            evaluatedExpression2 = expression2.evaluate().get(0);
        }

        List<NumberExpression> expressionList = new ArrayList<NumberExpression>();

        NumberExpression exp1 = (NumberExpression) evaluatedExpression1;
        expressionList.add(exp1);
        NumberExpression exp2 = (NumberExpression) evaluatedExpression2;
        expressionList.add(exp2);

        return expressionList;
        
        
        /*if(!(expression1 instanceof NumberExpression)){
            expression1 = expression1.evaluate().get(0);
        }

        if(!(expression2 instanceof NumberExpression)){
            expression2 = expression2.evaluate().get(0);
        }

        List<NumberExpression> expressionList = new ArrayList<NumberExpression>();

        NumberExpression exp1 = (NumberExpression) expression1;
        expressionList.add(exp1);
        NumberExpression exp2 = (NumberExpression) expression2;
        expressionList.add(exp2);

        return expressionList;*/
    }

 
    

}
