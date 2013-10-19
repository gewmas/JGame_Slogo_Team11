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
//                Expression parsedExpression = DefaultParser.parse(commandInput);
                expressionList.add(parsedExpression);
        }
        
        return expressionList;
    }
    
    public Expression parse (List<String> commandInput) throws SlogoException {
        String s = commandInput.get(0).toLowerCase();

        
        //Turtle Commands
        if (s.equals(messages.getString("Forward"))){
            return new ForwardExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Backward"))){
            return new BackExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Left"))){
            return new LeftExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Right"))){
            return new RightExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("SetHeading"))){
            return new SetHeadingExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("SetTowards"))){
            return new TowardsExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("SetPosition"))){
            return new SetXYExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("PenDown"))){
            commandInput.remove(0);
            return new PenDownExpression(model);
        }
        else if (s.equals(messages.getString("PenUp"))){
            commandInput.remove(0);
            return new PenUpExpression(model);
        }
        else if (s.equals(messages.getString("ShowTurtle"))){
            commandInput.remove(0);
            return new ShowTurtleExpression(model);
        }
        else if (s.equals(messages.getString("HideTurtle"))){
            commandInput.remove(0);
            return new HideTurtleExpression(model);
        }
        else if (s.equals(messages.getString("Home"))){
            commandInput.remove(0);
            return new HomeExpression(model);
        }
        else if (s.equals(messages.getString("ClearScreen"))){
            commandInput.remove(0);
            return new ClearScreenExpression(model);
        }
        
        //Turtle Queries
        else if (s.equals(messages.getString("XCoordinate"))){
            commandInput.remove(0);
            return new XCorExpression(model);
        }
        else if (s.equals(messages.getString("YCoordinate"))){
            commandInput.remove(0);
            return new YCorExpression(model);
        }
        else if (s.equals(messages.getString("Heading"))){
            commandInput.remove(0);
            return new HeadingExpression(model);
        }
        else if (s.equals(messages.getString("IsPenDown"))){
            commandInput.remove(0);
            return new IsPenDownExpression(model);
        }
        else if (s.equals(messages.getString("IsShowing"))){
            commandInput.remove(0);
            return new IsShowingExpression(model);
        }
        
        //Math Operations
        else if (s.equals(messages.getString("Sum"))){
            return new SumExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Difference"))){
            return new DifferenceExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Product"))){
            return new ProductExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Quotient"))){
            return new QuotientExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Remainder"))){
            return new RemainderExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Minus"))){
            return new MinusExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Random"))){
            return new RandomExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Sine"))){
            return new SinExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Cosine"))){
            return new CosExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Tangent"))){
            return new TanExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("ArcTangent"))){
            return new ATanExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("NaturalLog"))){
            return new LogExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Power"))){
            return new PowExpression(commandInput, model);
        }
        
        //Boolean Operations
        
        else if (s.equals(messages.getString("LessThan"))){
            return new LessExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("GreaterThan"))){
            return new GreaterExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Equal"))){
            return new EqualExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("NotEqual"))){
            return new NotEqualExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("And"))){
            return new AndExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Or"))){
            return new OrExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Not"))){
            return new NotExpression(commandInput, model);
        }
        
        // Variables, Control Structures, and User-Defined Commands
        else if (s.equals(messages.getString("MakeVariable"))){
            return new MakeExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("Repeat"))){
            return new RepeatExpression(commandInput, model);
        } else if(functionMap.containsKey(s)) {
            FunctionExpression functionExp = new FunctionExpression(commandInput, model);
            functionExp.checkFunctionDeclaration(functionMap.get(s));
            functionExp.convert(commandInput);
            return functionExp;
        }
        else if (s.equals(messages.getString("DoTimes"))){
            return new DoTimesExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("For"))){
            return new ForExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("If"))){
            return new IfExpression(commandInput, model);
        }
        else if (s.equals(messages.getString("IfElse"))){
            return new IfElseExpression(commandInput, model);
        }
        else if(s.equals(messages.getString("MakeUserInstruction"))){
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
        else if(s.equals(messages.getString("SetBackground"))) {
            return new setBackgroundExpression(commandInput);
        } else if(s.equals(messages.getString("SetPenColor"))) {
            return new setBackgroundExpression(commandInput);
        } else if(s.equals(messages.getString("SetPenSize"))) {
            return new setBackgroundExpression(commandInput);
        } else if(s.equals(messages.getString("SetShape"))) {
            return new setBackgroundExpression(commandInput);
        } 
        
        else {
            throw new SlogoException("Command not recognized");
        }

    }
}
