package model;

import java.util.Map;
import model.expression.Expression;

public interface GlobalVariableInterface {

    public Map<String, Expression> getGlobalVariables();
    
    public void addToGlobalVariables(String variable, Expression expression);
    
}
