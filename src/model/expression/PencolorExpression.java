package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;


public class PencolorExpression extends QueryExpression {

    public PencolorExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.penColor();
    }

}
