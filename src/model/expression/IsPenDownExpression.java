package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;


public class IsPenDownExpression extends QueryExpression {

    public IsPenDownExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.isPenDown();
    }

}
