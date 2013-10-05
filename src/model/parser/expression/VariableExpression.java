package model.parser.expression;

import java.util.List;

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
    public Expression evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

}
