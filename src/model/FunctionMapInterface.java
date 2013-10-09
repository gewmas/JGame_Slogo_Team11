package model;

import java.util.Map;
import model.expression.Expression;

public interface FunctionMapInterface {

    public Map<String, Expression> getFunctionMap();
    
    public void addToFunctionMap(String name, Expression expression);
    
}
