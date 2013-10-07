package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.expression.*;

public class DefaultParser extends Parser {
    private static Map<String, Expression> functionMap;

    public DefaultParser(){
    }
    
    public List<Expression> execute(List<String> commandInput, Map<String, Expression> functionMap){
        DefaultParser.functionMap = functionMap;
        
        List<Expression> expressionList = new ArrayList<Expression>();
        
        while(!commandInput.isEmpty()){
            expressionList.add(DefaultParser.parse(commandInput));
        }
        
        return expressionList;
    }
    
    public static Expression parse (List<String> commandInput) {
        String s = commandInput.get(0).toLowerCase();

        
        //Turtle Commands
        if (s.equals("fd") || s.equals("forward")){
            return new ForwardExpression(commandInput);
        }
        else if (s.equals("bk") || s.equals("back")){
            return new BackExpression(commandInput);
        }
        else if (s.equals("lt") || s.equals("left")){
            return new LeftExpression(commandInput);
        }
        else if (s.equals("rt") || s.equals("right")){
            return new RightExpression(commandInput);
        }
        else if (s.equals("seth") || s.equals("setheading")){
            return new SetHeadingExpression(commandInput);
        }
        else if (s.equals("towards")){
            return new TowardsExpression(commandInput);
        }
        else if (s.equals("setxy") || s.equals("goto")){
            return new SetXYExpression(commandInput);
        }
        else if (s.equals("pd") || s.equals("pendown")){
            commandInput.remove(0);
            return new PenDownExpression();
        }
        else if (s.equals("pu") || s.equals("penup")){
            commandInput.remove(0);
            return new PenUpExpression();
        }
        else if (s.equals("st") || s.equals("showturtle")){
            commandInput.remove(0);
            return new ShowTurtleExpression();
        }
        else if (s.equals("ht") || s.equals("hideturtle")){
            commandInput.remove(0);
            return new HideTurtleExpression();
        }
        else if (s.equals("home")){
            commandInput.remove(0);
            return new HomeExpression();
        }
        else if (s.equals("cs") || s.equals("clearscreen")){
            commandInput.remove(0);
            return new ClearScreenExpression();
        }
        
        //Turtle Queries
        else if (s.equals("xcor")){
            commandInput.remove(0);
            return new XCorExpression();
        }
        else if (s.equals("ycor")){
            commandInput.remove(0);
            return new YCorExpression();
        }
        else if (s.equals("heading")){
            commandInput.remove(0);
            return new HeadingExpression();
        }
        else if (s.equals("pendownp") || s.equals("pendown?")){
            commandInput.remove(0);
            return new IsPenDownExpression();
        }
        else if (s.equals("showingp") || s.equals("showing?")){
            commandInput.remove(0);
            return new IsShowingExpression();
        }
        
        //Math Operations
        else if (s.equals("sum")){
            return new SumExpression(commandInput);
        }
        else if (s.equals("difference")){
            return new DifferenceExpression(commandInput);
        }
        else if (s.equals("product")){
            return new ProductExpression(commandInput);
        }
        else if (s.equals("quotient")){
            return new QuotientExpression(commandInput);
        }
        else if (s.equals("remainder")){
            return new RemainderExpression(commandInput);
        }
        else if (s.equals("minus")){
            return new MinusExpression(commandInput);
        }
        else if (s.equals("random")){
            return new RandomExpression(commandInput);
        }
        else if (s.equals("sin")){
            return new SinExpression(commandInput);
        }
        else if (s.equals("cos")){
            return new CosExpression(commandInput);
        }
        else if (s.equals("tan")){
            return new TanExpression(commandInput);
        }
        else if (s.equals("atan")){
            return new ATanExpression(commandInput);
        }
        else if (s.equals("log")){
            return new LogExpression(commandInput);
        }
        else if (s.equals("pow")){
            return new PowExpression(commandInput);
        }
        
        //Boolean Operations
        else if (s.equals("lessp") || s.equals("less?")){
            return new LessExpression(commandInput);
        }
        else if (s.equals("greaterp") || s.equals("greater?")){
            return new GreaterExpression(commandInput);
        }
        else if (s.equals("equalp") || s.equals("equal?")){
            return new EqualExpression(commandInput);
        }
        else if (s.equals("notequalp") || s.equals("notequal?")){
            return new NotEqualExpression(commandInput);
        }
        else if (s.equals("and")){
            return new AndExpression(commandInput);
        }
        else if (s.equals("or")){
            return new OrExpression(commandInput);
        }
        else if (s.equals("not")){
            return new NotExpression(commandInput);
        }
        
        // Variables, Control Structures, and User-Defined Commands
        else if (s.equals("make") || s.equals("set")){
            return new MakeExpression(commandInput);
        }
        else if (s.equals("repeat")){
            return new RepeatExpression(commandInput);
        } else if(functionMap.containsKey(s)) {
            FunctionExpression functionExp = new FunctionExpression(commandInput);
            functionExp.checkFunctionDeclaration(functionMap.get(s));
            functionExp.convert(commandInput);
            return functionExp;
        }
        else if (s.equals("dotimes")){
            return new DoTimesExpression(commandInput);
        }
        else if (s.equals("for")){
            return new ForExpression(commandInput);
        }
        else if (s.equals("if")){
            return new IfExpression(commandInput);
        }
        else if (s.equals("ifelse")){
            return new IfElseExpression(commandInput);
        }
        else if(s.equals("to")){
            commandInput.remove(0);
            FunctionDeclarationExpression functionDeclaration = new FunctionDeclarationExpression(commandInput);
            functionMap.put(commandInput.get(0), functionDeclaration);
            return functionDeclaration;
        }
        else if(commandInput.get(0).charAt(0) == ':'){
            return new VariableExpression(commandInput);
        }

        return null;
    }
}
