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
    private ControllerToModelInterface controller;
    private Parser parser;
    
    //temp instance variable from current workspace, update everytime model get called
    private Map<String, Expression> definedFunction;
    private Map<String, Expression> runningFunction;
    private Map<String, Expression> globalVariables;

    List<Turtle> activeTurtle;

    public DefaultModel(Controller controller){
        this.controller = controller;
        parser = new DefaultParser(this, controller.getMessages());
    }
    
    private void updateInstanceVariable(){
        definedFunction = controller.getDefinedFunction();
        runningFunction = controller.getRunningFunction();
        globalVariables = controller.getGlobalVariables();
        
      //get TurtleTrace of every activeTurtle
        activeTurtle = controller.getActiveTurtles();
    }

    public void updateTrace (String userInput) throws SlogoException {

        updateInstanceVariable();
        
        TurtleCommand latestTurtleCommand;
        List<TurtleCommand> tempTurtleCommand;

        // convert command
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("[\\s,;\\n\\t]+")));//"\\s+")));       
        
        List<Expression> expressionList;
        expressionList = parser.execute(commandInput, definedFunction);

      
        for(Turtle turtle : activeTurtle){
            TurtleTrace turtleTrace = turtle.getTurtleTrace();

            //TODO: evaluate Tell, TellEven, TellOdd, Ask, AskWith
            
            // evaluate & create TurtleCommand
            for (Expression expression : expressionList) {
                if(expression.getClass().getSuperclass().getSimpleName().equals("QueryExpression") || expression.getClass().getSuperclass().getSimpleName().equals("FourParameterExpression")){
                    ((QueryExpression) expression).executeControllerCommand(controller);
                    continue;
                }
                
                if(expression.getClass().getSuperclass().getSimpleName().equals("FourParameterExpression")){
                    ((SetPaletteExpression) expression).executeControllerCommand(controller);
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

    public Map<String, Expression> getGlobalVariables () {
        return globalVariables;
    }

    public Parser getParser () {
        return parser;
    }

    public Map<String, Expression> getRunningFunction () {
        return runningFunction;
    }

    
}
