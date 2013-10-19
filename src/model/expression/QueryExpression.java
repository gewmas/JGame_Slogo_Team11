package model.expression;

import java.util.List;
import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public abstract class QueryExpression extends Expression {

    public QueryExpression (Model model) {
        super(model);
    }

    @Override
    public void convert (List<String> cmdList) {

    }

    @Override
    public List<Expression> evaluate () {
        return null;
    }
    
    public abstract void executeControllerCommand(ControllerToModelInterface controller);

}
