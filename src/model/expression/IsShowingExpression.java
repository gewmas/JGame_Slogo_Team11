package model.expression;

import Exceptions.SlogoException;
import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public class IsShowingExpression extends QueryExpression {

    public IsShowingExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.isShowing();
    }

}
