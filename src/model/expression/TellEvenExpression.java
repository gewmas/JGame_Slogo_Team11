package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;

public class TellEvenExpression extends TellExpression {

    public TellEvenExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.getCurrentWorkspace().setEvenActiveTurtle();
    }

}
