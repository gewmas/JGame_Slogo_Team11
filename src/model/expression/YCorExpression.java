    package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class YCorExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.yCor();
    }

}
