package model.parser;

import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import model.expression.Expression;

public abstract class Parser {

    public abstract List<Expression> execute(List<String> commandInput,  Map<String, Expression> functionMap) throws SlogoException;
//    public abstract Expression parse (List<String> asList, int i);
    
//    public abstract Expression parse(List<String> commandInput);
}
