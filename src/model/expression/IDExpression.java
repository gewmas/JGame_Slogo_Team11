package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;

public class IDExpression extends QueryExpression {

    public IDExpression (Model model) throws SlogoException {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.id();
    }

}
