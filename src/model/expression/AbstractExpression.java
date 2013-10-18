package model.expression;

import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public abstract class AbstractExpression {
    public abstract void convert(List<String> cmdList) throws SlogoException;
    public abstract List<Expression> evaluate();
    public abstract List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd);
    
}
