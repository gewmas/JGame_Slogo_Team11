package model.expression;

import model.Model;
import controller.Controller;
import controller.ControllerToModelInterface;

public class XCorExpression extends QueryExpression {

    public XCorExpression (Model model) {
        super(model);
    }

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.xCor();
    }

}
