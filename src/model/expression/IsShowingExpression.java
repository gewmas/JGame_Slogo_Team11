package model.expression;

import controller.Controller;
import controller.ControllerToModelInterface;

public class IsShowingExpression extends QueryExpression {

    @Override
    public void executeControllerCommand (ControllerToModelInterface controller) {
        controller.isShowing();
    }

}
