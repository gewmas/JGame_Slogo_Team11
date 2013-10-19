package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import Exceptions.SlogoException;
import controller.Controller;
import controller.ControllerToModelInterface;
import controller.SlogoError;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;
import model.parser.DefaultParser;
import model.parser.Parser;
import model.expression.*;

public class DefaultModel extends Model {
//    private static Map<String, Expression> functionMap;
//    private static Map<String, Expression> globalVariables;

    private ControllerToModelInterface controller;
    List<Turtle> activeTurtle;
    TurtleTrace turtleTrace;

    public DefaultModel(Controller controller){
        functionMap = new HashMap<String, Expression>();
        globalVariables = new HashMap<String, Expression>();
        this.controller = controller;
    }

    public void updateActiveTurtle(){
        activeTurtle = controller.getActiveTurtles();
    }

    public void updateTrace (String userInput, ResourceBundle messages) throws SlogoException {
        TurtleCommand latestTurtleCommand;
        List<TurtleCommand> tempTurtleCommand;

        // convert command
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("[\\s,;\\n\\t]+")));//"\\s+")));       
        Parser parser = new DefaultParser();
        List<Expression> expressionList;
        expressionList = parser.execute(commandInput, functionMap);

        //get TurtleTrace of every activeTurtle
        updateActiveTurtle();
        for(Turtle turtle : activeTurtle){
            turtleTrace = turtle.getTurtleTrace();

            // evaluate & create TurtleCommand
            for (Expression expression : expressionList) {
                if(expression.getClass().getSuperclass().getSimpleName().equals("QueryExpression")){
                    ((QueryExpression) expression).executeControllerCommand(controller);
                    continue;
                }

                // If make called from top level, then need to flag it as global 
                if(expression instanceof MakeExpression) {
                    MakeExpression makeExp = (MakeExpression) expression;
                    makeExp.setIsGlobal(true);
                    makeExp.evaluate();
                    continue;
                }
                
                // Skip FunctionDeclarationExpression
                if(expression instanceof FunctionDeclarationExpression){
                    continue;
                }

                //Here check IF expression is of type that doesnt return turtleCommand.  ????
                latestTurtleCommand = new TurtleCommand(turtleTrace.getLatest());
                tempTurtleCommand = expression.createTurtleCommands(latestTurtleCommand);
                turtleTrace.add(tempTurtleCommand);
            }
            
        }



    }

    public static Map<String, Expression> getGlobalVariables() {
        return globalVariables;
    }


}
