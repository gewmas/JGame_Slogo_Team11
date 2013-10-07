package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.DefaultModel;

public class VariableExpression extends Expression{
    String id;
    
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
        Map<String, Expression> localVars = FunctionExpression.getLocalVariables();
        
        if(localVars.containsKey(id)) {
            finalExpressionList.add(localVars.get(id));
            return finalExpressionList;
            
        } else if(globalVars.containsKey(id)) {
            finalExpressionList.add(globalVars.get(id));
        }
        
        return finalExpressionList;
        
    }

    public String getId () {
        return id;
    }

}
