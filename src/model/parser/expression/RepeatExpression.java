package model.parser.expression;

import java.util.ArrayList;
import java.util.List;
import model.parser.DefaultParser;

public class RepeatExpression extends Expression {
    Expression expression1;
    Expression expression2;
//    List<Expression> expression2;

    public RepeatExpression(List<String> cmdList){
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

        expression1 = DefaultParser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));
        expression2 = DefaultParser.parse(new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex)));
        //"repeat sum 1 2 [ fd sum 1 2 repeat 3 [ fd sum 1 2 ] ] fd sum 1 2"
        
        /*List<String> expression2CmdList = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!expression2CmdList.isEmpty()){
            expression2.add(DefaultParser.parse(expression2CmdList));
        }*/
        
        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
        
//        cmdList = cmdList.subList(closeBracketIndex+1, cmdList.size());
        
    }

    @Override
    public Expression evaluate () {
        return null;

    }

}
