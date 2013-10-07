package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.DefaultModel;

public class VariableExpression extends Expression{
    String id;
    
    public VariableExpression(String id){
        this.id = id;
    }
    
    public VariableExpression(VariableExpression rhs){
        this(rhs.getId());
    }
    
    public VariableExpression(List<String> cmdList){
        id = cmdList.get(0).substring(1);
        cmdList.remove(0);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();

        Map<String, Expression> globalVars = DefaultModel.getGlobalVariables();
        Map<String, Expression> localVars = ScopedExpression.getLocalVariables();
        
        if(localVars.containsKey(id)) {
            Expression expression = localVars.get(id);
            finalExpressionList.addAll(expression.evaluate());
            return finalExpressionList;
            
        } else if(globalVars.containsKey(id)) {
            Expression expression = globalVars.get(id);
            finalExpressionList.addAll(expression.evaluate());
        }
        
        return finalExpressionList;
        
    }

    public String getId () {
        return id;
    }

}
