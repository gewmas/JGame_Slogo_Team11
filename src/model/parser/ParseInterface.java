package model.parser;

import java.util.List;
import model.expression.Expression;

public interface ParseInterface {
    
    public Expression parse(List<String> commandInput);

}
