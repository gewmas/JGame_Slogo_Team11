package controller;

import java.util.List;

public class TurtleTrace {
    List<TurtleCommand> commandList;
 
    public void add(TurtleCommand turtleCommand){
        commandList.add(turtleCommand);
    }
    
    public List<TurtleCommand> getCommandList () {
        return commandList;
    }
    
    
}
