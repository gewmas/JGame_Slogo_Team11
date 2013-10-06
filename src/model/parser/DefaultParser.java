package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.expression.*;

public class DefaultParser extends Parser {
    private static Map<String, Expression> functionMap;

    public DefaultParser(){
    }
    
    public List<Expression> execute(List<String> commandInput, Map<String, Expression> functionMap){
        DefaultParser.functionMap = functionMap;
        
        List<Expression> expressionList = new ArrayList<Expression>();
        
        while(!commandInput.isEmpty()){
            expressionList.add(DefaultParser.parse(commandInput));
        }
        
        return expressionList;
    }
    
    public static Expression parse (List<String> commandInput) {
        String s = commandInput.get(0).toLowerCase();

        if (s.equals("sum")){
            return new SumExpression(commandInput);
        }
        else if (s.equals("fd")){
            return new ForwardExpression(commandInput);
        }
        else if (s.equals("bk")){
            return new BackExpression(commandInput);
        }
        else if (s.equals("lt")){
            return new LeftExpression(commandInput);
        }
        else if (s.equals("rt")){
            return new RightExpression(commandInput);
        }
        else if (s.equals("seth")){
            return new SetHeadingExpression(commandInput);
        }
        else if (s.equals("repeat")){
            return new RepeatExpression(commandInput);
        } else if(functionMap.containsKey(s)) {
            FunctionExpression functionExp = new FunctionExpression(commandInput);
            functionExp.checkFunctionDeclaration(functionMap.get(s));
            functionExp.convert(commandInput);
            return functionExp;
        }
        else if(s.equals("to")){
            commandInput.remove(0);
            functionMap.put(commandInput.get(0), new FunctionDeclarationExpression(commandInput));
            // return ???
        }else if(commandInput.get(0).charAt(0) == ':'){
            return new VariableExpression(commandInput);
        }

        return null;
    }
}
