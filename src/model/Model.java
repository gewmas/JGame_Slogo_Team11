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

public class Model implements TurtleTraceInterface, FunctionMapInterface {
    private static Map<String, Expression> functionMap;
    private static Map<String, Expression> globalVariables;

    private Controller controller;
    List<Turtle> activeTurtle;
    TurtleTrace turtleTrace;

    public Model(Controller controller){
        functionMap = new HashMap<String, Expression>();
        globalVariables = new HashMap<String, Expression>();
        this.controller = controller;
    }

    public void updateActiveTurtle(){
        activeTurtle = controller.getActiveTurtles();
    }

    public void updateTrace (String userInput) {
        TurtleCommand latestTurtleCommand;
        List<TurtleCommand> tempTurtleCommand;

        // convert command
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("[\\s,;\\n\\t]+")));//"\\s+")));       

        //get TurtleTrace of every activeTurtle
        updateActiveTurtle();
        for(Turtle turtle : activeTurtle){
            turtleTrace = turtle.getTurtleTrace();
            
            Parser parser = new DefaultParser(this);
            List<Expression> expressionList = parser.execute(commandInput, functionMap);

            if(expressionList == null) {
                SlogoError error = new SlogoError("Parse Error", "A syntax error occured while parsing your script");
                turtleTrace.setSlogoError(error);
            }

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
        
        //CLEAR GLOBAL VARIABLES



    }
    
    /*
     * TurtleTrace Interface methods
     * */
    
    public TurtleTrace getTurtleTrace() {
        return turtleTrace;
    }
    
    public void updateTurtleTrace(List<TurtleCommand> turtleCommands) {
        turtleTrace.add(turtleCommands);
    }
    
    public TurtleCommand getLastTurtleCommand() {
        return turtleTrace.getLatest();      
    }

    
    /*
     * FunctionMap Interface methods
     * */
    
    public Map<String, Expression> getFunctionMap() {
        return functionMap;
    }
    
    public void addToFunctionMap(String name, Expression expression) {
        functionMap.put(name, expression);
    }
    
    /*
     * GlobalVariable Interface methods
     * */
    
    public Map<String, Expression> getGlobalVariables() {
        return globalVariables;
    }
    
    public void addToGlobalVariables(String name, Expression expression) {
        globalVariables.put(name, expression);
    }


}
