package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.DefaultModel;
import model.parser.DefaultParser;

/**
 * make :random sum 1 random 100
 * Assuming only one variable after "make"
 * 
 */

public class MakeExpression extends Expression {
    Map<String, Expression> variables; //Though assuming one variable, making it map for extend
    boolean isGlobal;
    
    public MakeExpression(List<String> cmdList){
        variables = new HashMap<String, Expression>();
        isGlobal = false;
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0); //remove make
        
        String id = cmdList.get(0).substring(1);
        cmdList.remove(0); // remove :random
        
        Expression expression = DefaultParser.parse(cmdList);
        
        variables.put(id, expression);
    }

    @Override
    public List<Expression> evaluate () {
        
        for (Map.Entry<String, Expression> entry : variables.entrySet()) {
                        
                if(isGlobal) {
                    Map<String, Expression> globalVars = DefaultModel.getGlobalVariables();
                    globalVars.put(entry.getKey(), entry.getValue());
                } else {
                    Map<String, Expression> localVars = FunctionExpression.getLocalVariables();
                    localVars.put(entry.getKey(), entry.getValue());
                }
            }
        
        return new ArrayList<Expression>();
        
    }
    
    public void setIsGlobal(boolean value) {
        isGlobal = value;
    }

}
