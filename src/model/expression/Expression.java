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

    public Expression (Model model) throws SlogoException {
        this.model = model;
        this.parser = model.getParser();
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        
    }

    @Override
    public List<Expression> evaluate () throws SlogoException {
        return null;
    }

    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) throws SlogoException {
        return null;
    }

    
}
