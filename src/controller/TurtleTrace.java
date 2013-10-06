package controller;

import java.util.List;

public class TurtleTrace {
    List<TurtleCommand> commandList;
    Error error;
 
    public void add(TurtleCommand turtleCommand){
        commandList.add(turtleCommand);
    }
    
    public void add(List<TurtleCommand> turtleCommands){
        for(TurtleCommand turtleCommand : turtleCommands){
            commandList.add(turtleCommand);
        }
    }
    
    public List<TurtleCommand> getCommandList () {
        return commandList;
    }
    
    public void setTurtlePenUp(){
        
    }
    
    public void setTurtlePenDown(){
        
    }
    
    public void getTurtlePenColor(){
        
    }
    
    public void setTurtlePenColor(){
        
    }
    
}
