    package model.expression;

import Exceptions.SlogoException;
import model.Model;
import controller.ControllerToModelInterface;

public class YCorExpression extends QueryExpression {

    public YCorExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.yCor();
    }

}
