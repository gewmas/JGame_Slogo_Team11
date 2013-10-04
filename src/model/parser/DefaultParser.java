package model.parser;

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


}
