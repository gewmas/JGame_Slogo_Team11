package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;

public class TellOddExpression extends TellExpression {

    public TellOddExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.getCurrentWorkspace().setOddActiveTurtle();
    }

}
