package model.expression;

import java.util.List;
import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;


public abstract class QueryExpression extends Expression {

    public QueryExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {

    }

    @Override
    public List<Expression> evaluate () {
        return null;
    }

    public abstract void executeControllerCommand (ControllerToModelInterface controller);

}
