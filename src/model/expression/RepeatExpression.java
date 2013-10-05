package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;

public class RepeatExpression extends Expression {
    Expression expression1;
//    Expression expression2;
    List<Expression> expression2;

    public RepeatExpression(List<String> cmdList){
        expression2 = new ArrayList<Expression>();
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        //Problem with following codes if repeat [] inside another repeat
        for(int i = 0; i < cmdList.size(); i++){
            if(cmdList.get(i).equals("[")){
                if(openBracketIndex == -1){
                    openBracketIndex = i;
                }
                bracketNumber++;
            }else if(cmdList.get(i).equals("]")){
                bracketNumber--;
                if(bracketNumber == 0){
                    closeBracketIndex = i;
                    break;
                }
            }
        }

        try
        {
            expression1 = new NumberExpression(Double.parseDouble(cmdList.get(0)));
//            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            expression1 = DefaultParser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));
        }
        
//        expression1 = DefaultParser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));

        List<String> expression2CmdList = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!expression2CmdList.isEmpty()){
            expression2.add(DefaultParser.parse(expression2CmdList));
        }
        
        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
        
//        cmdList = cmdList.subList(closeBracketIndex+1, cmdList.size());
        
    }

    @Override
    // Must think about whether expressions being evaluated can check for variables defined outside of repeat scope!
    public List<Expression> evaluate() {
    	NumberExpression repeatNumberExp = (NumberExpression) expression1;
    	// For number of specified repeats, execute the commands within repeat brackets
    	List<Expression> finalExpressionList = new ArrayList<Expression>();
    	for (int i = 0; i < repeatNumberExp.getNumber(); i++) {	
    		for (Expression expression : expression2) {
    			finalExpressionList.addAll(expression.evaluate());
			}
		}
    	return finalExpressionList;
    }

}
