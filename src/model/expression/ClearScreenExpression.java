package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;


public class ClearScreenExpression extends QueryExpression {

    public ClearScreenExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.clearScreen();
    }

}
