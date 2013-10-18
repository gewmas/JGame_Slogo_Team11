package controller;

import java.util.ArrayList;
import java.util.List;

public class TurtleTrace {
    List<TurtleCommand> commandList;
    SlogoError error;
 
    public TurtleTrace(){
        commandList = new ArrayList<TurtleCommand>();
        commandList.add(new TurtleCommand(0, 0, 90)); //default TurtleCommand
    }
    
    public void add(TurtleCommand turtleCommand){
        commandList.add(turtleCommand);
    }
    
    public void add(List<TurtleCommand> turtleCommands){
        for(TurtleCommand turtleCommand : turtleCommands){
            commandList.add(turtleCommand);
        }
    }
    
    public TurtleCommand getLatest() {
        if(commandList.size() == 0) {
            return new TurtleCommand(0, 0, 90);
        }
        return commandList.get(commandList.size()-1);
    }
    
    public List<TurtleCommand> getCommandList () {
        return commandList;
    }
    
    public void clearCommandList(){
        commandList.clear();
        commandList.add(new TurtleCommand(0, 0, 90));
    }
    
    public void setTurtlePenUp(){
        
    }
    
    public void setTurtlePenDown(){
        
    }
    
    public void getTurtlePenColor(){
        
    }
    
    public void setTurtlePenColor(){
        
    }

    public SlogoError getError () {
        return error;
    }

    public void setSlogoError (SlogoError error) {
        this.error = error;
    }
    
}
