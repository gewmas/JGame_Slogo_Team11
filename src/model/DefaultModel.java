package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.parser.DefaultParser;
import model.parser.Parser;
import model.parser.expression.Expression;

public class DefaultModel extends Model {

    public void updateTrace (String userInput) {
        //"sum 5 sum 8 9"
        List<String> commandInput = new ArrayList<String>(Arrays.asList(userInput.split("\\s+")));       
        
        Parser parser = new DefaultParser();
        List<Expression> expressionList = parser.execute(commandInput);
        
//        Expression evl = answer.evaluate();
    }

    public static void main(String[] args){
        //      List<String> commandInput = new ArrayList<String>(Arrays.asList("sum", "sum", "2", "sum", "1", "sum", "5", "sum", "8", "9", "10"));
        //      List<String> commandInput = new ArrayList<String>(Arrays.asList("sum", "9", "10"));

        //      List<String> commandInput = new ArrayList<String>(Arrays.asList("fd", "sum", "sum", "2", "sum", "1", "sum", "5", "sum", "8", "9", "10"));
        
        
        DefaultModel model = new DefaultModel();
//        model.updateTrace("sum sum 2 sum 1 sum 5 sum 8 9 10");
//        model.updateTrace("fd sum sum 2 sum 1 sum 5 sum 8 9 10");
//        model.updateTrace("repeat sum 1 2 [ fd sum 1 2 ]");
//        model.updateTrace("repeat sum 1 2 [ fd sum 1 2 ] fd sum 1 2");
        model.updateTrace("repeat sum 1 2 [ fd sum 1 2 repeat 3 [ fd sum 1 2 ] ] fd sum 1 2");
        
    }
}
