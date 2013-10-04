package model;

import java.util.Arrays;
import java.util.List;

public class DefaultModel extends Model {
    Parser parser;
    
    @Override
    public void updateTrace (String userInput) {
        List<String> commandInputList = parseInput(userInput);
        
    }
    
    @Override
    public List<String> parseInput (String userInput) {
        String[] commandInput = userInput.split("\\s+");
        return Arrays.asList(commandInput);
    }

    

}
