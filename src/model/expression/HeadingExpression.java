package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;


public class HeadingExpression extends QueryExpression {

    public HeadingExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.heading();
    }

}
