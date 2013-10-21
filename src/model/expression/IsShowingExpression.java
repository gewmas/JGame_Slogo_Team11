package model.expression;

import model.Model;
import Exceptions.SlogoException;
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
