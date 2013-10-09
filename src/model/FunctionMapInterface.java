package model;

import java.util.Map;
import model.expression.Expression;

public interface FunctionMapInterface {

    public Map<String, Expression> getFunctionMap();
    
    public void updateFunctionMap(String function, Expression expression);
    
}
