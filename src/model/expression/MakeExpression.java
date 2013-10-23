package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import viewer.UserVariableBox;
import controller.TurtleCommand;
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
    private Map<String, Expression> variables; //Though assuming one variable, making it map for extend
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
    public List<Expression> evaluate () throws SlogoException {
        
        for (Map.Entry<String, Expression> entry : variables.entrySet()) {
                
            //valid local variable
            ScopedExpression scopedExpression = null;
            Map<String, Expression> localVars = null;
            if(!model.getFunctionStack().empty()){
                scopedExpression = (ScopedExpression) model.getRunningFunction().get(model.getFunctionStack().peek());
            }
            if(scopedExpression != null){
                localVars = scopedExpression.getLocalVariables();
            }
            if(localVars != null){
                localVars.put(entry.getKey(), entry.getValue().evaluate().get(0));
                return new ArrayList<Expression>();
            }
            
            //global variable&& no valid local variable
            Map<String, Expression> globalVars = model.getGlobalVariables();
            globalVars.put(entry.getKey(), entry.getValue().evaluate().get(0));
            
//                if(isGlobal) {
//                    Map<String, Expression> globalVars = model.getGlobalVariables();
//                    globalVars.put(entry.getKey(), entry.getValue());
//                } else {
//                    //TO-DO NOT sure get function name
//                    ScopedExpression scopedExpression = (ScopedExpression) model.getRunningFunction().get(model.getFunctionStack().peek());
//                    Map<String, Expression> localVars = scopedExpression.getLocalVariables();
//                    localVars.put(entry.getKey(), entry.getValue().evaluate().get(0));
//                }
            }
        
        return new ArrayList<Expression>();
        
    }
    
    public void setIsGlobal(boolean value) {
        isGlobal = value;
    }

    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) throws SlogoException {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        commandList.add(turtleCmd);
        
        evaluate();
        
        return commandList;
    }
    
    public HashMap<String, Expression> getVariables() {
    	return (HashMap<String, Expression>) variables;
    }
    
    
}
