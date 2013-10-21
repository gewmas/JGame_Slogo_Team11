package model.expression;

import Exceptions.SlogoException;
import model.Model;
import controller.ControllerToModelInterface;

public class XCorExpression extends QueryExpression {

    public XCorExpression (Model model) throws SlogoException {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.xCor();
    }

}
