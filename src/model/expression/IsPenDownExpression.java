package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class IsPenDownExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.isPenDown();
    }

}
