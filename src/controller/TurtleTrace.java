package controller;

import java.util.List;

public class TurtleTrace {
    List<TurtleCommand> commandList;
    Error error;
 
    public void add(TurtleCommand turtleCommand){
        commandList.add(turtleCommand);
    }
    
    public List<TurtleCommand> getCommandList () {
        return commandList;
    }
    
    
}
