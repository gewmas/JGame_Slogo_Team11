package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.ControllerToModelInterface;
import model.Model;
import Exceptions.SlogoException;

public class TellDefaultExpression extends TellExpression {
    
    private ArrayList<String> turtleIds;
    
    public TellDefaultExpression (Model model) throws SlogoException {
        super(model);
        turtleIds = new ArrayList<String>();
    }
    
    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0);

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

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
        
        //Within [ :count ]
        for(int i = openBracketIndex+1; i < closeBracketIndex; i++){
            turtleIds.add(cmdList.get(i));
            cmdList.remove(0);
        }
        
        cmdList.remove(0); // remove [
        cmdList.remove(0); // remove ]
    }
    

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.getCurrentWorkspace().setActiveTurtle(turtleIds);
    }

}
