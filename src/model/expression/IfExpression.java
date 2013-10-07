package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;

public class IfExpression extends Expression {

    Expression conditionExpression; //assuming one expression
    List<Expression> commandExpression;
    
    /*
     * IF expr [ command(s) ]
     * if lessp 2 3 [ fd sum 1 2 ]
     */
    public IfExpression(List<String> cmdList){
        commandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0); // remove if

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

        
        
        conditionExpression = DefaultParser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));

        List<String> commandCmdList = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!commandCmdList.isEmpty()){
            commandExpression.add(DefaultParser.parse(commandCmdList));
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
