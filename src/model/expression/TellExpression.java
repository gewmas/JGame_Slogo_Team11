package model.expression;

import model.Model;
import Exceptions.SlogoException;
import controller.ControllerToModelInterface;

public class TellExpression extends QueryExpression {

    public TellExpression (Model model) throws SlogoException {
        super(model);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        // TODO Auto-generated method stub

    }

}
