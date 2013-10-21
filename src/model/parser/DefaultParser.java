package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import Exceptions.SlogoException;
import model.Model;
import model.expression.*;

public class DefaultParser extends Parser {
    
    private Model model;
    private Map<String, Expression> functionMap;
    ResourceBundle messages;

    public DefaultParser(Model model, ResourceBundle messages){
        this.model = model;
        this.messages = messages;
    }
    
    public List<Expression> execute(List<String> commandInput, Map<String, Expression> functionMap) throws SlogoException {
        this.functionMap = functionMap;
        
        List<Expression> expressionList = new ArrayList<Expression>();
        
        while(!commandInput.isEmpty()){
            Expression parsedExpression = parse(commandInput);
            expressionList.add(parsedExpression);
        }
        
        return expressionList;
    }
    
    public boolean equals(String command, String message) {
        
        String[] messages = message.split(",");
        
        for (String msg : messages) {
            if(command.equals(msg)) {
                return true;
            }
        }
        
        return false;
    }
    
    public Expression parse (List<String> commandInput) throws SlogoException {
        String s = commandInput.get(0).toLowerCase();

        //Turtle Commands
        if (equals(s, messages.getString("Forward"))){
            return new ForwardExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Backward"))){
            return new BackExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Left"))){
            return new LeftExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Right"))){
            return new RightExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("SetHeading"))){
            return new SetHeadingExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("SetTowards"))){
            return new TowardsExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("SetPosition"))){
            return new SetXYExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("PenDown"))){
            commandInput.remove(0);
            return new PenDownExpression(model);
        }
        else if (equals(s, messages.getString("PenUp"))){
            commandInput.remove(0);
            return new PenUpExpression(model);
        }
        else if (equals(s, messages.getString("ShowTurtle"))){
            commandInput.remove(0);
            return new ShowTurtleExpression(model);
        }
        else if (equals(s, messages.getString("HideTurtle"))){
            commandInput.remove(0);
            return new HideTurtleExpression(model);
        }
        else if (equals(s, messages.getString("Home"))){
            commandInput.remove(0);
            return new HomeExpression(model);
        }
        else if (equals(s, messages.getString("ClearScreen"))){
            commandInput.remove(0);
            return new ClearScreenExpression(model);
        }
        
        //Turtle Queries
        else if (equals(s, messages.getString("XCoordinate"))){
            commandInput.remove(0);
            return new XCorExpression(model);
        }
        else if (equals(s, messages.getString("YCoordinate"))){
            commandInput.remove(0);
            return new YCorExpression(model);
        }
        else if (equals(s, messages.getString("Heading"))){
            commandInput.remove(0);
            return new HeadingExpression(model);
        }
        else if (equals(s, messages.getString("IsPenDown"))){
            commandInput.remove(0);
            return new IsPenDownExpression(model);
        }
        else if (equals(s, messages.getString("IsShowing"))){
            commandInput.remove(0);
            return new IsShowingExpression(model);
        }
        
        //Math Operations
        else if (equals(s, messages.getString("Sum"))){
            return new SumExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Difference"))){
            return new DifferenceExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Product"))){
            return new ProductExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Quotient"))){
            return new QuotientExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Remainder"))){
            return new RemainderExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Minus"))){
            return new MinusExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Random"))){
            return new RandomExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Sine"))){
            return new SinExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Cosine"))){
            return new CosExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Tangent"))){
            return new TanExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("ArcTangent"))){
            return new ATanExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("NaturalLog"))){
            return new LogExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Power"))){
            return new PowExpression(commandInput, model);
        }
        
        //Boolean Operations
        
        else if (equals(s, messages.getString("LessThan"))){
            return new LessExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("GreaterThan"))){
            return new GreaterExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Equal"))){
            return new EqualExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("NotEqual"))){
            return new NotEqualExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("And"))){
            return new AndExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Or"))){
            return new OrExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Not"))){
            return new NotExpression(commandInput, model);
        }
        
        // Variables, Control Structures, and User-Defined Commands
        else if (equals(s, messages.getString("MakeVariable"))){
            return new MakeExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("Repeat"))){
            return new RepeatExpression(commandInput, model);
        } else if(functionMap != null && functionMap.containsKey(s)) {
            FunctionExpression functionExp = new FunctionExpression(commandInput, model);
            functionExp.checkFunctionDeclaration(functionMap.get(s));
            functionExp.convert(commandInput);
            return functionExp;
        }
        else if (equals(s, messages.getString("DoTimes"))){
            return new DoTimesExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("For"))){
            return new ForExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("If"))){
            return new IfExpression(commandInput, model);
        }
        else if (equals(s, messages.getString("IfElse"))){
            return new IfElseExpression(commandInput, model);
        }
        else if(equals(s, messages.getString("MakeUserInstruction"))){
            commandInput.remove(0);
            String funName = commandInput.get(0);
            FunctionDeclarationExpression functionDeclaration = new FunctionDeclarationExpression(commandInput, model);
            functionMap.put(funName, functionDeclaration);
            return functionDeclaration;
        }
        else if(commandInput.get(0).charAt(0) == ':'){

            return new VariableExpression(commandInput, model);
        } 
        
        // Display Commands
        else if(equals(s, messages.getString("SetBackground"))) {
            return new SetBackgroundExpression(commandInput, model );
        } 
        else if(equals(s, messages.getString("SetPenColor"))) {
            return new SetPenColorExpression(commandInput, model);
        } 
        else if(equals(s, messages.getString("SetPenSize"))) {
            return new SetPenSizeExpression(commandInput, model);
        } 
        else if(equals(s, messages.getString("SetShape"))) {
            return new SetShapeExpression(commandInput, model);
        } 
        else if(equals(s, messages.getString("SetPalette"))) {
            return new SetShapeExpression(commandInput, model);
        }
        
        else if(equals(s, messages.getString("Tell"))) {
            return new TellDefaultExpression(commandInput, model);
        } 
        else if(equals(s, messages.getString("TellEven"))) {
            return new TellEvenExpression(model);
        }
        else if(equals(s, messages.getString("TellOdd"))) {
            return new TellOddExpression(model);
        }
        else if(equals(s, messages.getString("Ask"))) {
            return new AskExpression(commandInput, model);
        }
        // TODO ask with here
        else if(equals(s, messages.getString("AskWith"))) {
            //return new AskWithExpression(commandInput, model);
        }
        
        else {
            throw new SlogoException("Command not recognized");
        }
        
        return null;

    }
}
