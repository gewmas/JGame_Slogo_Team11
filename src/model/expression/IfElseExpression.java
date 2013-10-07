package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;

public class IfElseExpression extends Expression {

    Expression conditionExpression; //assuming one expression
    List<Expression> ifCommandExpression;
    List<Expression> elseCommandExpression;
    
    /*
     * IFELSE expr [ trueCommand(s) ]  [ falseCommand(s) ]
     * if lessp 2 3 [ fd sum 1 2 ] [ fd sum 1 sum 1 2 ]
     */
    
    public IfElseExpression(List<String> cmdList){
        ifCommandExpression = new ArrayList<Expression>();
        elseCommandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0); // remove if

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        //Within [ ifCommand ]
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

        
        
        conditionExpression = DefaultParser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));

      //Within [ ifCommand ]
        List<String> ifCommand = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!ifCommand.isEmpty()){
            ifCommandExpression.add(DefaultParser.parse(ifCommand));
        }
        
        
        // remove   expr  [ ifCommand ]
        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

        openBracketIndex = -1;
        closeBracketIndex = -1;
        bracketNumber = 0;

        //Within [ elseCommand ]
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

        List<String> elseCommands = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!elseCommands.isEmpty()){
            elseCommandExpression.add(DefaultParser.parse(elseCommands));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
    }

    @Override
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

}
