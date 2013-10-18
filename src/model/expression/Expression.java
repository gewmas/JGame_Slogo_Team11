package model.expression;

import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public class Expression extends AbstractExpression{

   

    public Expression (Expression expression) {
        this();
    }

    public Expression () {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
