package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import model.Model;
import model.expression.*;

public class DefaultParser extends Parser {
    
    private Model model;
    private Map<String, Expression> functionMap;

    public DefaultParser(Model model){
        this.model = model;
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
        if (s.equals("fd") || s.equals("forward")){
            return new ForwardExpression(commandInput, model);
        }
        else if (s.equals("bk") || s.equals("back")){
            return new BackExpression(commandInput, model);
        }
        else if (s.equals("lt") || s.equals("left")){
            return new LeftExpression(commandInput, model);
        }
        else if (s.equals("rt") || s.equals("right")){
            return new RightExpression(commandInput, model);
        }
        else if (s.equals("seth") || s.equals("setheading")){
            return new SetHeadingExpression(commandInput, model);
        }
        else if (s.equals("towards")){
            return new TowardsExpression(commandInput, model);
        }
        else if (s.equals("setxy") || s.equals("goto")){
            return new SetXYExpression(commandInput, model);
        }
        else if (s.equals("pd") || s.equals("pendown")){
            commandInput.remove(0);
            return new PenDownExpression(model);
        }
        else if (s.equals("pu") || s.equals("penup")){
            commandInput.remove(0);
            return new PenUpExpression(model);
        }
        else if (s.equals("st") || s.equals("showturtle")){
            commandInput.remove(0);
            return new ShowTurtleExpression(model);
        }
        else if (s.equals("ht") || s.equals("hideturtle")){
            commandInput.remove(0);
            return new HideTurtleExpression(model);
        }
        else if (s.equals("home")){
            commandInput.remove(0);
            return new HomeExpression(model);
        }
        else if (s.equals("cs") || s.equals("clearscreen")){
            commandInput.remove(0);
            return new ClearScreenExpression(model);
        }
        
        //Turtle Queries
        else if (s.equals("xcor")){
            commandInput.remove(0);
            return new XCorExpression(model);
        }
        else if (s.equals("ycor")){
            commandInput.remove(0);
            return new YCorExpression(model);
        }
        else if (s.equals("heading")){
            commandInput.remove(0);
            return new HeadingExpression(model);
        }
        else if (s.equals("pendownp") || s.equals("pendown?")){
            commandInput.remove(0);
            return new IsPenDownExpression(model);
        }
        else if (s.equals("showingp") || s.equals("showing?")){
            commandInput.remove(0);
            return new IsShowingExpression(model);
        }
        
        //Math Operations
        else if (s.equals("sum")){
            return new SumExpression(commandInput, model);
        }
        else if (s.equals("difference")){
            return new DifferenceExpression(commandInput, model);
        }
        else if (s.equals("product")){
            return new ProductExpression(commandInput, model);
        }
        else if (s.equals("quotient")){
            return new QuotientExpression(commandInput, model);
        }
        else if (s.equals("remainder")){
            return new RemainderExpression(commandInput, model);
        }
        else if (s.equals("minus")){
            return new MinusExpression(commandInput, model);
        }
        else if (s.equals("random")){
            return new RandomExpression(commandInput, model);
        }
        else if (s.equals("sin")){
            return new SinExpression(commandInput, model);
        }
        else if (s.equals("cos")){
            return new CosExpression(commandInput, model);
        }
        else if (s.equals("tan")){
            return new TanExpression(commandInput, model);
        }
        else if (s.equals("atan")){
            return new ATanExpression(commandInput, model);
        }
        else if (s.equals("log")){
            return new LogExpression(commandInput, model);
        }
        else if (s.equals("pow")){
            return new PowExpression(commandInput, model);
        }
        
        //Boolean Operations
        
        else if (s.equals("lessp") || s.equals("less?")){
            return new LessExpression(commandInput, model);
        }
        else if (s.equals("greaterp") || s.equals("greater?")){
            return new GreaterExpression(commandInput, model);
        }
        else if (s.equals("equalp") || s.equals("equal?")){
            return new EqualExpression(commandInput, model);
        }
        else if (s.equals("notequalp") || s.equals("notequal?")){
            return new NotEqualExpression(commandInput, model);
        }
        else if (s.equals("and")){
            return new AndExpression(commandInput, model);
        }
        else if (s.equals("or")){
            return new OrExpression(commandInput, model);
        }
        else if (s.equals("not")){
            return new NotExpression(commandInput, model);
        }
        
        
        // Variables, Control Structures, and User-Defined Commands
        else if (s.equals("make") || s.equals("set")){
            return new MakeExpression(commandInput, model);
        }
        else if (s.equals("repeat")){
            return new RepeatExpression(commandInput, model);
        } else if(functionMap.containsKey(s)) {
            FunctionExpression functionExp = new FunctionExpression(commandInput, model);
            functionExp.checkFunctionDeclaration(functionMap.get(s));
            functionExp.convert(commandInput);
            return functionExp;
        }
        else if (s.equals("dotimes")){
            return new DoTimesExpression(commandInput, model);
        }
        else if (s.equals("for")){
            return new ForExpression(commandInput, model);
        }
        else if (s.equals("if")){
            return new IfExpression(commandInput, model);
        }
        else if (s.equals("ifelse")){
            return new IfElseExpression(commandInput, model);
        }
        else if(s.equals("to")){
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
        else if(s.equals("setbackground")) {
            return new setBackgroundExpression(commandInput);
        } else if(s.equals("setpencolor")) {
            return new setBackgroundExpression(commandInput);
        } else if(s.equals("setpensize")) {
            return new setBackgroundExpression(commandInput);
        } else if(s.equals("setshape")) {
            return new setBackgroundExpression(commandInput);
        } 
        
        else {
            throw new SlogoException("Command not recognized");
        }

    }
}
