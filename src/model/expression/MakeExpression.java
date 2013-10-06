package model.expression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.parser.DefaultParser;

/**
 * make :random sum 1 random 100
 * Assuming only one variable after "make"
 * 
 */

public class MakeExpression extends Expression {
    Map<String, Expression> variables; //Though assuming one variable, making it map for extend
    
    public MakeExpression(List<String> cmdList){
        variables = new HashMap<String, Expression>();
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
        // TODO Auto-generated method stub
        return null;
    }

}
