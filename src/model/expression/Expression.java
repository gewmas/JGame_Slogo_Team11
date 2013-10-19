package model.expression;

import java.util.List;
import model.Model;
import model.parser.Parser;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public class Expression extends AbstractExpression{

     Model model;
     Parser parser;

//    public Expression (Expression expression) {
//        this();
//    }

    public Expression (Model model) {
        this.model = model;
        this.parser = model.getParser();
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
