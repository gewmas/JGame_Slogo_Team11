package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;

public class ForExpression extends ScopedExpression{
    
    VariableExpression variableExpression; //Assuming just one variable
    Expression startExpression;
    Expression endExpression;
    Expression incrementExpression;
    
    List<Expression> commandExpression; //command(s)

    /*
     * FOR [ variable start end increment ] [ command(s) ]
     * 
     * for [ :i sum 1 3 sum 1 3 sum 1 3 ] [  fd 23 fd 23 ]
     * 
     */
    public ForExpression(List<String> cmdList){
        commandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);
        
        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        // Find [ variable start end increment ]
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

        //Within [ variable start end increment ]
        variableExpression = new VariableExpression(new ArrayList<String>(cmdList.subList(1, 2))); // assuming just on variable
        cmdList.remove(0); // remove [
        cmdList.remove(0); // remove variable
        
        startExpression = DefaultParser.parse(cmdList);
        endExpression = DefaultParser.parse(cmdList);
        incrementExpression = DefaultParser.parse(cmdList);
        
        cmdList.remove(0); // remove ]  

        
        
        // --------------------------

        openBracketIndex = -1;
        closeBracketIndex = -1;
        bracketNumber = 0;

        //Within [ command(s) ]
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

        List<String> commands = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!commands.isEmpty()){
            commandExpression.add(DefaultParser.parse(commands));
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
