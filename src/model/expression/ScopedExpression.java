package model.expression;

import java.util.HashMap;
import java.util.Map;
import model.Model;

public class ScopedExpression extends Expression {

    protected String functionId;
    protected Map<String, Expression> localVariables = new HashMap<String, Expression>();
    
    public ScopedExpression (Model model) {
        super(model);
    }
    
    public Map<String, Expression> getLocalVariables() {
        return localVariables;
    }
}
