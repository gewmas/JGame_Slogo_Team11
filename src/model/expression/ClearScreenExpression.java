package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class ClearScreenExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.clearScreen();
    }

}
