package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.parser.DefaultParser;

public class FunctionExpression extends Expression {

    List<Expression> parameters;
    int numberOfParameters;
    List<String> commandList;

    public FunctionExpression(List<String> cmdList){
        parameters = new ArrayList<Expression>();
        commandList = cmdList;
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);
        
       for (int i = 0; i < numberOfParameters; i++) {
           
           try
           {
               NumberExpression finalExp = new NumberExpression(Double.parseDouble(cmdList.get(0)));
               parameters.add(finalExp);
               cmdList.remove(0);
           }
           catch (NumberFormatException e)
           {
               parameters.add(DefaultParser.parse(cmdList));
           }
           
       }
                           
    }
    
    public void checkFunctionDeclaration(Expression exp) {
        FunctionDeclarationExpression declarationExp = (FunctionDeclarationExpression) exp;
        numberOfParameters = declarationExp.numberOfVariables();
    }
    
}
