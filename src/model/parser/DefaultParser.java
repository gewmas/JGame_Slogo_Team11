package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.parser.expression.*;

public class DefaultParser extends Parser {
    private static Map<String, Expression> functionMap;

    public DefaultParser(){
        functionMap = new HashMap<String, Expression>();
    }
    
    public List<Expression> execute(List<String> commandInput){
        List<Expression> expressionList = new ArrayList<Expression>();
        
        while(!commandInput.isEmpty()){
            expressionList.add(DefaultParser.parse(commandInput));
        }
        
        return expressionList;
    }
    
    public static Expression parse (List<String> commandInput) {
        String s = commandInput.get(0);

        if (s.equals("sum")){
            return new SumExpression(commandInput);
        }
        else if (s.equals("fd")){
            return new ForwardExpression(commandInput);
        }
        else if (s.equals("repeat")){
            return new RepeatExpression(commandInput);
        }else if(s.equals("to")){
            commandInput.remove(0);
            functionMap.put(commandInput.get(0), new FunctionExpression(commandInput));
            // return ???
        }else if(commandInput.get(0).indexOf(0) == ':'){
            return new VariableExpression(commandInput);
        }

        return null;
    }
}
