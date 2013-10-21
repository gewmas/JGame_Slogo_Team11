package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Stack;
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
    //keep track of whether within FunctionExpression
    private Stack<String> functionStack;

    List<Turtle> activeTurtles;

    public DefaultModel(Controller controller){
        this.controller = controller;
        parser = new DefaultParser(this, controller.getMessages());
        functionStack = new Stack<String>();
    }
    
    private void updateInstanceVariable(){
        definedFunction = controller.getDefinedFunction();
        runningFunction = controller.getRunningFunction();
        globalVariables = controller.getGlobalVariables();
        
        functionStack.clear();
        
      //get TurtleTrace of every activeTurtle
      activeTurtles = controller.getActiveTurtles();
    }

    public void updateTrace (String userInput) throws SlogoException {

        updateInstanceVariable();

        // convert command
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("[\\s,;\\n\\t]+")));//"\\s+")));       
        
        List<Expression> expressionList = parser.execute(commandInput, definedFunction);
        
        createTraceForTurtles(expressionList);
        
    }
    
    public void createTraceForTurtles(List<Expression> expressionList) throws SlogoException {
        
        TurtleCommand latestTurtleCommand;
        List<TurtleCommand> tempTurtleCommand;
        
        List<Turtle> tempActiveTurtles = new ArrayList<Turtle>(activeTurtles);
        
        List<Expression> tempExpressionList = new ArrayList<Expression>();
      
        for(Turtle turtle : tempActiveTurtles){
            TurtleTrace turtleTrace = turtle.getTurtleTrace();          
            
            // evaluate & create TurtleCommand
            for (int i = 0; i < expressionList.size(); i++) {
                Expression expression = expressionList.get(i);
                
                //TODO: evaluate Tell, TellEven, TellOdd, Ask, AskWith
                if(expression.getClass().getSuperclass().getSimpleName().equals("TellExpression")) {
                    //The activeTurtles is going to change from here on out.
                    //create list of remaining commands
                    
//                    tempExpressionList.addAll(expressionList);
                  
//                    tempExpressionList.remove(i);
                    
                    tempExpressionList = new ArrayList<Expression>(expressionList.subList(i+1, expressionList.size()));
                    ((TellExpression) expression).executeControllerCommand(controller);
                    break;
                }
                
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
                
                /*if(expression instanceof FunctionExpression){
                    FunctionDeclarationExpression functionDeclaration = ((FunctionExpression) expression).getFunctionDeclaration();
                    String functionName = functionDeclaration.getFunctionName();
                    runningFunction.put(functionName, expression);
                }*/

                latestTurtleCommand = new TurtleCommand(turtleTrace.getLatest());
                tempTurtleCommand = expression.createTurtleCommands(latestTurtleCommand);
                turtleTrace.add(tempTurtleCommand);
            }
            
        }
        
        if(tempExpressionList.size() > 0) {
            createTraceForTurtles(tempExpressionList);
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

    public Stack<String> getFunctionStack () {
        return functionStack;
    }

    @Override
    public ControllerToModelInterface getController () {
        return controller;
    }

    
}
