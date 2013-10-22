package model.expression;

import java.util.HashMap;
import java.util.Map;
import Exceptions.SlogoException;
import model.Model;
import viewer.UserDefinedCommandsBox;

public class ScopedExpression extends Expression {

    protected String functionId;
    protected Map<String, Expression> localVariables = new HashMap<String, Expression>();

    public ScopedExpression (Model model) throws SlogoException {
        super(model);
    }

    public Map<String, Expression> getLocalVariables () {
        return localVariables;
    }
    
    public String getFunctionId() {
    	return this.functionId;
    }
}
