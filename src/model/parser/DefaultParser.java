package model.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.parser.expression.*;

public class DefaultParser extends Parser {
//    private static List<String> commandInput;

    public DefaultParser() {
        
    }

    public static Expression parse(List<String> commandInput, int begin) {
        // {"sum", "5", "sum", "8", "9"}

        if(commandInput.get(0).equals("sum")) {
            return new SumExpression(commandInput, begin);
        }
        
        return null;

//        return "22";
    }
    
    public static void main(String[] args){
        List<String> commandInput = new ArrayList<String>(Arrays.asList("sum", "sum", "2", "sum", "1", "sum", "5", "sum", "8", "9", "10"));
//        List<String> commandInput = new ArrayList<String>(Arrays.asList("sum", "9", "10"));
        Expression answer = DefaultParser.parse(commandInput, 0);
//        System.out.println(answer.evaluate());
        Expression evl = answer.evaluate();
    }


}
