package model.expression;

import java.util.HashMap;
import java.util.Map;

public class ScopedExpression extends Expression {

    private Map<String, Expression> localVariables = new HashMap<String, Expression>();
    
    public Map<String, Expression> getLocalVariables() {
        return localVariables;
    }
}
