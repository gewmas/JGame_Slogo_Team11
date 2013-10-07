package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import controller.Controller;
import controller.SlogoError;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;
import model.parser.DefaultParser;
import model.parser.Parser;
import model.expression.*;

public class DefaultModel extends Model {
    private static Map<String, Expression> functionMap;
    private static Map<String, Expression> globalVariables;
    
    private Controller controller;
    
    public DefaultModel(Controller controller){
        functionMap = new HashMap<String, Expression>();
        globalVariables = new HashMap<String, Expression>();
        this.controller = controller;
    }
    
    public void updateTrace (String userInput) {
        //cs, xcoo, ycoor, heading, pendown?, showing?..
        
        //"sum 5 sum 8 9"
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("[\\s,;\\n\\t]+")));//"\\s+")));       
        
        TurtleCommand latestTurtleCommand;
        List<TurtleCommand> tempTurtleTrace;
        TurtleTrace turtleTrace = new TurtleTrace();
        
        Parser parser = new DefaultParser();
        List<Expression> expressionList = parser.execute(commandInput, functionMap);
        
        if(expressionList == null) {
            SlogoError error = new SlogoError("Parse Error", "A syntax error occured while parsing your script");
            turtleTrace.setSlogoError(error);
        }
        
        for (Expression expression : expressionList) {
            //Here check IF expression is of type that doesnt return turtleCommand. 
            //OneParameterExpression exp = (OneParameterExpression) expression;

            if(expression.getClass().getSuperclass().getSimpleName().equals("QueryExpression")){
                ((QueryExpression) expression).executeControllerCommand(controller);
                continue;
            }
            // If make called from top level, then need to flag it as global 
            if(expression instanceof MakeExpression) {
                MakeExpression makeExp = (MakeExpression) expression;
                makeExp.setIsGlobal(true);
            }

            latestTurtleCommand = new TurtleCommand(turtleTrace.getLatest());
            tempTurtleTrace = expression.createTurtleCommands(latestTurtleCommand);
            turtleTrace.add(tempTurtleTrace);
        }
        
        //Expression evl = answer.evaluate();
    }
    
    public static Map<String, Expression> getGlobalVariables() {
        return globalVariables;
    }

 
}
