package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.parser.DefaultParser;
import controller.TurtleCommand;

public class DoTimesExpression extends ScopedExpression {

    VariableExpression variableExpression; //Assuming just one variable
    List<Expression> expression1; //limit
    
    List<Expression> expression2; //command(s)
    
    private static Map<String, Expression> localVariables;
    
    /*
     * DOTIMES [ variable limit ] [ command(s) ]
     * 
     * DOTIMES [ :i sum 1 3 ] [ fd 23 fd 23 ]
     * 
     */
    public DoTimesExpression(List<String> cmdList){
        expression1 = new ArrayList<Expression>();
        expression2 = new ArrayList<Expression>();
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);
        
        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

      //Find [ variable limit ]
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

        //Within [ variable limit ]
        variableExpression = new VariableExpression(new ArrayList<String>(cmdList.subList(1, 2))); // assuming just on variable
        List<String> limits = new ArrayList<String>(cmdList.subList(openBracketIndex+2, closeBracketIndex));
        while(!limits.isEmpty()){
            expression1.add(DefaultParser.parse(limits));
        }
            

        //Remove [ variable limit ]
        for(int i = openBracketIndex; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

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
            expression2.add(DefaultParser.parse(commands));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
    }

    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        // TODO Auto-generated method stub
        return null;
    }


}
