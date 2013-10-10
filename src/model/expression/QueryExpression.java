package model.expression;

import java.util.List;
import controller.Controller;
import controller.ControllerToModelInterface;

public abstract class QueryExpression extends Expression {

    @Override
    public void convert (List<String> cmdList) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        return null;
    }
    
    public abstract void executeControllerCommand(ControllerToModelInterface controller);

}
