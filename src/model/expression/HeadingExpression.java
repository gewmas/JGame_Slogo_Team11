package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class HeadingExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.heading();
    }

}
