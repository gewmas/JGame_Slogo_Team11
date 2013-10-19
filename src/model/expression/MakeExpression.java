package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import model.DefaultModel;
import model.Model;
import model.parser.DefaultParser;

/**
 * make :random sum 1 random 100
 * Assuming only one variable after "make"
 * 
 */

public class MakeExpression extends Expression {
    Map<String, Expression> variables; //Though assuming one variable, making it map for extend
    boolean isGlobal;
    
    public MakeExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
        variables = new HashMap<String, Expression>();
        isGlobal = false;
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0); //remove make
        
        String id = cmdList.get(0).substring(1);
        cmdList.remove(0); // remove :random
        

        Expression expression;
        
        try
        {
            expression = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression = parser.parse(cmdList);
        }
        
        
        variables.put(id, expression);
    }

    @Override
    public List<Expression> evaluate () {
        
        for (Map.Entry<String, Expression> entry : variables.entrySet()) {
                        
                if(isGlobal) {
                    Map<String, Expression> globalVars = model.getGlobalVariables();
                    globalVars.put(entry.getKey(), entry.getValue());
                } else {
                    //TO-DO NOT sure get function name
                    ScopedExpression scopedExpression = (ScopedExpression) model.getRunningFunction().get("");
                    Map<String, Expression> localVars = scopedExpression.getLocalVariables();
                    localVars.put(entry.getKey(), entry.getValue());
                }
            }
        
        return new ArrayList<Expression>();
        
    }
    
    public void setIsGlobal(boolean value) {
        isGlobal = value;
    }

}
