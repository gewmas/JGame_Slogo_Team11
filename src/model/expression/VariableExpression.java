package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import model.Model;

public class VariableExpression extends Expression{
    String id;
    String functionId;
    
    public VariableExpression(String id, String functionId, Model model) throws SlogoException{
        super(model);
        this.id = id;
        this.functionId = functionId;
    }
    
    public VariableExpression(VariableExpression rhs, Model model) throws SlogoException{
        this(rhs.getId(), "global", model);
    }
    
    public VariableExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
        id = cmdList.get(0).substring(1);
        cmdList.remove(0);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        
    }

    @Override
    public List<Expression> evaluate () throws SlogoException {
        List<Expression> finalExpressionList = new ArrayList<Expression>();

        Map<String, Expression> globalVars = model.getGlobalVariables();
        Map<String, Expression> localVars = null;
        
        String withinFunction = null;
        ScopedExpression scopedExpression = null;
        
        if(!model.getFunctionStack().empty()){
            withinFunction = model.getFunctionStack().peek();
        }
        if(withinFunction != null){
            scopedExpression = (ScopedExpression) model.getRunningFunction().get(withinFunction);   
        }
        if(scopedExpression != null){
            localVars = scopedExpression.getLocalVariables();
        }
  
        if(localVars != null && localVars.containsKey(id)) {
            Expression expression = localVars.get(id);
            finalExpressionList.addAll(expression.evaluate());
            return finalExpressionList;
            
        } else if(globalVars.containsKey(id)) {
            Expression expression = globalVars.get(id);
            finalExpressionList.addAll(expression.evaluate());
            return finalExpressionList;
        }
        
        throw new SlogoException("Can not evaluate variable" + id);
        
    }

    public String getId () {
        return id;
    }

}
