package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.ControllerToModelInterface;
import Exceptions.SlogoException;
import model.Model;

public class FourParameterExpression extends Expression {
    Expression expression1;
    Expression expression2;
    Expression expression3;
    Expression expression4;
    

    public FourParameterExpression(List<String> cmdList, Model model) throws SlogoException {
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
        
        try
        {
            expression3 = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression3 = parser.parse(cmdList);
        }
        
        try
        {
            expression4 = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression4 = parser.parse(cmdList);
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
      Expression evaluatedExpression3 = expression3;
      Expression evaluatedExpression4 = expression4;
        
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
        
        if(expression3 instanceof VariableExpression){
            evaluatedExpression3 = new VariableExpression((VariableExpression)expression3, model);
        }
        
        if(!(expression3 instanceof NumberExpression)){
            evaluatedExpression3 = expression3.evaluate().get(0);
        }
        
        if(expression4 instanceof VariableExpression){
            evaluatedExpression4 = new VariableExpression((VariableExpression)expression4, model);
        }
        
        if(!(expression4 instanceof NumberExpression)){
            evaluatedExpression4 = expression4.evaluate().get(0);
        }

        List<NumberExpression> expressionList = new ArrayList<NumberExpression>();

        NumberExpression exp1 = (NumberExpression) evaluatedExpression1;
        expressionList.add(exp1);
        NumberExpression exp2 = (NumberExpression) evaluatedExpression2;
        expressionList.add(exp2);
        NumberExpression exp3 = (NumberExpression) evaluatedExpression3;
        expressionList.add(exp3);
        NumberExpression exp4 = (NumberExpression) evaluatedExpression4;
        expressionList.add(exp4);

        return expressionList;

    }

     
    

}


