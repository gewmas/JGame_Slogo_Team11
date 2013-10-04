package model;

import java.util.Arrays;
import java.util.List;

import model.parser.Parser;

public class DefaultModel extends Model {
    Parser parser;
    
    @Override
    public void updateTrace (String userInput) {
    	//"sum 5 sum 8 9"
        List<String> commandInputList = parseInput(userInput);
        
    }
    
    @Override
    public List<String> parseInput (String userInput) {
        String[] commandInput = userInput.split("\\s+");
        return Arrays.asList(commandInput);
    }

    

}
