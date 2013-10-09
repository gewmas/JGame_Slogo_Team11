package model;

import java.util.List;
import controller.TurtleCommand;
import controller.TurtleTrace;

public interface TurtleTraceInterface {

    public TurtleTrace getTurtleTrace();
    
    public void updateTurtleTrace(List<TurtleCommand> turtleCommand);
    
}
