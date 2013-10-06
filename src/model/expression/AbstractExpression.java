package model.expression;

import java.util.List;
import controller.TurtleCommand;

public abstract class AbstractExpression {
    public abstract void convert(List<String> cmdList);
    public abstract List<Expression> evaluate();
    public abstract TurtleCommand createTurtleCommand(TurtleCommand turtleCmd);
}
