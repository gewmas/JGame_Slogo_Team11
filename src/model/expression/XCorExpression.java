package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class XCorExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.xCor();
    }

}
