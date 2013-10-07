package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;
import model.parser.DefaultParser;
import model.parser.Parser;
import model.expression.*;

public class DefaultModel extends Model {
    private static Map<String, Expression> functionMap;
    
    private Controller controller;
    
    public DefaultModel(Controller controller){
        functionMap = new HashMap<String, Expression>();
        this.controller = controller;
    }
    
    public void updateTrace (String userInput) {
        //cs, xcoo, ycoor, heading, pendown?, showing?..
        
        //"sum 5 sum 8 9"
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("[\\s,;\\n\\t]+")));//"\\s+")));       
        
        Parser parser = new DefaultParser();
        List<Expression> expressionList = parser.execute(commandInput, functionMap);
        
        TurtleCommand latestTurtleCommand = new TurtleCommand(0, 0, 90);
        TurtleTrace turtleTrace = new TurtleTrace();
        
        for (Expression expression : expressionList) {
            //Here check IF expression is of type that doesnt return turtleCommand. 
//            OneParameterExpression exp = (OneParameterExpression) expression;
            
            if(expression.getClass().getSuperclass().getSimpleName().equals("QueryExpression")){
                ((QueryExpression) expression).executeControllerCommand(controller);
                continue;
            }
            
            latestTurtleCommand = new TurtleCommand(latestTurtleCommand);
            latestTurtleCommand = expression.createTurtleCommand(latestTurtleCommand);
            turtleTrace.add(latestTurtleCommand);
            
        }
        
        //Expression evl = answer.evaluate();
    }

 
}
