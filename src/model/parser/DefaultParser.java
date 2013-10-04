package model.parser;

import java.util.ArrayList;
import java.util.List;
import model.parser.expression.*;

public class DefaultParser extends Parser {

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
        }

        return null;
    }
}
